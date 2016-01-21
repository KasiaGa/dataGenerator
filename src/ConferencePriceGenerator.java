import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-21.
 */
public class ConferencePriceGenerator {

    Generator generator = new Generator();
    ArrayList<String> dates;
    ArrayList<String> conferencePriceList = new ArrayList<>();

    public ConferencePriceGenerator() {
        this.dates = generator.readFile("output/dates.sql");
    }

    public void generateConferencePrice() {
        int counter = 1;
        for(String date: dates) {
            System.out.println(date);
            ConferencePrice cp = new ConferencePrice(date, counter);
            counter++;
            conferencePriceList.add(cp.toString());
        }
    }

    public ArrayList<String> getConferencePriceList() {
        return conferencePriceList;
    }

}
