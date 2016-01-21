import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kasia on 2016-01-21.
 */
public class Workshops {

    private int conferenceDateID;
    private String workshopName;
    private int capacity;
    private int location;
    private String startHour;
    private String endHour;
    private String price;
    private String studentDiscount;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<String> workshopNames;

    public Workshops(int conferenceDateID, int capacity) {
        Generator generator = new Generator();
        this.workshopNames = generator.readFile("data/workshops.txt");
        Random random = new Random();
        this.conferenceDateID = conferenceDateID;

        int numOfWorkshops = random.nextInt(5);
        for(int i=0; i<numOfWorkshops; i++) {
            this.workshopName = generator.select(workshopNames);
            this.capacity = random.nextInt((capacity-10)/10)*10 +10;
            this.price = random.nextInt(51) + ".00";
            this.studentDiscount = "00." + random.nextInt(3) + "0";
            this.location = random.nextInt(499) + 1;
            int hour = random.nextInt(13) + 8;
            this.startHour = hour/10 + "" + hour%10 + ":00:00";
            int hourEnd = hour + random.nextInt(3)+1;
            this.endHour = hourEnd/10 + "" + hourEnd%10 + ":00:00";
            sb.append("exec AddWorkshop " + this.conferenceDateID + ", '" + this.workshopName + "', " +
            this.capacity + ", " + this.location + ", " + this.startHour + ", " + this.endHour + ", " +
            this.price + ", " + this.studentDiscount + "\n");
        }

    }

    public String toString() {
        return sb.toString();
    }
}
