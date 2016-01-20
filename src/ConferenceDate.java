import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Kasia on 2016-01-20.
 */
public class ConferenceDate {

    private ArrayList<String> dateArray = new ArrayList<>();
    private int[] startDate = new int[3];
    private int[] endDate = new int[3];
    private int conferenceID;
    private int capacity;

    public ConferenceDate(String startDate, int id) {
        String dateSplit[] = startDate.split(" ");
        String startDateString;
        String endDateString;
        startDateString = dateSplit[0];
        endDateString = dateSplit[1];
        this.startDate[0] = 1000*(startDateString.charAt(0)-48) + 100*(startDateString.charAt(1)-48) + 10 * (startDateString.charAt(2)-48) +
                startDateString.charAt(3)-48;
        this.startDate[1] = 10 * (startDateString.charAt(5)-48) + startDateString.charAt(6)-48;
        this.startDate[2] = 10 * (startDateString.charAt(8)-48) + startDateString.charAt(9)-48;

        endDate[0] = 1000*(endDateString.charAt(0)-48) + 100*(endDateString.charAt(1)-48) + 10 * (endDateString.charAt(2)-48) +
                endDateString.charAt(3)-48;
        endDate[1] = 10 * (endDateString.charAt(5)-48) + endDateString.charAt(6)-48;
        endDate[2] = 10 * (endDateString.charAt(8)-48) + endDateString.charAt(9)-48;

        dateArray.add(this.startDate[0] + "-" + this.startDate[1]/10 + this.startDate[1]%10 + "-" + this.startDate[2]/10 + this.startDate[2]%10);

        do {
            this.startDate[2] += 1;

            if(this.startDate[2] > 28) {
                if(this.startDate[1] == 2) { // jak jest luty
                    this.startDate[2] = (this.startDate[2])%28;
                    this.startDate[1] += 1;
                }
            }
            if(this.startDate[2] > 30) {
                if(this.startDate[1] == 4 || this.startDate[1] == 6 || this.startDate[1] == 9 || this.startDate[1] == 11) {
                    this.startDate[2] = (this.startDate[2])%30;
                    this.startDate[1] += 1;
                }
            }
            if(this.startDate[2] > 31) {
                if(this.startDate[1] == 12) {
                    this.startDate[2] = (this.startDate[2])%31;
                    this.startDate[1] = 1;
                    this.startDate[0] = this.startDate[0] + 1;
                }
                else {
                    this.startDate[2] = (this.startDate[2])%31;
                    this.startDate[1] += 1;
                }
            }

            dateArray.add(this.startDate[0] + "-" + this.startDate[1]/10 + this.startDate[1]%10 + "-" + this.startDate[2]/10 + this.startDate[2]%10);
            System.out.println(this.startDate[0] + " " + this.endDate[0]);
            System.out.println(dateArray.get(0));
        }
        while(this.startDate[2] != this.endDate[2]);

        this.conferenceID = id;

        Random r = new Random();
        int number = r.nextInt(11);
        this.capacity = 150 + number*10;
    }


    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(String s: dateArray) {
            sb.append("exec AddConferenceDate ");
            sb.append(s).append(", ").append(this.conferenceID).append(", ").append(this.capacity).append('\n');
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public String getCapacity() {

        StringBuilder ub = new StringBuilder();

        for(String s: dateArray) {
            ub.append(this.capacity).append("\n");
        }

        return ub.toString();
    }

}
