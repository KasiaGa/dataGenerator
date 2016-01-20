import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-20.
 */
public class ConferenceDateGenerator {

    Generator generator = new Generator();
    ArrayList<String> startEndDates;
    ArrayList<String> conferenceDateList = new ArrayList<>();
    ArrayList<String> capacityList = new ArrayList<>();

    public ConferenceDateGenerator() {
        this.startEndDates = generator.readFile("output/startEndDates.sql");
    }

    public void generateConferenceDate() {
        int counter = 1;
        for(String date: startEndDates) {
            ConferenceDate cd = new ConferenceDate(date, counter);
            counter++;
            conferenceDateList.add(cd.toString());
            capacityList.add(cd.getCapacity());
        }
    }

    public ArrayList<String> getConferenceDateList() {
        return conferenceDateList;
    }

    public ArrayList<String> getCapacityList() {
        return capacityList;
    }

}
