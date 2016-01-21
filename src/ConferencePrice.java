import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kasia on 2016-01-21.
 */
public class ConferencePrice {

    private ArrayList<String> untilDates = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();
    private int conferenceDateID;
    private int[] untilDate = new int[3];
    private String price;

    public ConferencePrice(String date, int id) {

        Random random = new Random();
        this.untilDate[0] = 1000*(date.charAt(0)-48) + 100*(date.charAt(1)-48) + 10 * (date.charAt(2)-48) + date.charAt(3)-48;
        this.untilDate[1] = 10 * (date.charAt(5)-48) + date.charAt(6)-48;
        this.untilDate[2] = 10 * (date.charAt(8)-48) + date.charAt(9)-48;

        conferenceDateID = id;

        // substracting from month

        int counter = random.nextInt(5) + 1;
        int price = (random.nextInt(5) + 1)*10;

        for(int i=0; i<counter; i++) {
            if(untilDate[1] == 1) {
                untilDate[1] = 12;
                untilDate[0]--;
            }
            else {
                untilDate[1]--;
            }

            price += 15;
            this.price = price + ".00";
            prices.add(this.price);
            untilDates.add(untilDate[0] + "-" + untilDate[1]/10 + untilDate[1]%10 + "-" +untilDate[2]/10 + untilDate[2]%10);
        }


    }


    public String toString() {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String s: untilDates) {
            sb.append("exec AddConferencePrice '");
            sb.append(s).append("', '").append(prices.get(i)).append("', ").append(conferenceDateID).append('\n');
            i++;
        }

        //System.out.println(sb.toString());
        return sb.toString();
    }
}
