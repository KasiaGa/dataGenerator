import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-15.
 */
public class ConferenceGenerator {

    Generator generator = new Generator();
    ArrayList<String> cities;
    ArrayList<String> streets;

    ArrayList<String> conferencesList;
    ArrayList<String> startEndDates;

    public ConferenceGenerator() {
        this.cities = generator.readFile("data/cities.txt");
        this.streets = generator.readFile("data/streets.txt");

        conferencesList = new ArrayList<>();
        startEndDates = new ArrayList<>();
    }

    public void generateConferences() {
        for(int i=1; i<73; i++) {
            String city = generator.select(cities);
            String street = generator.select(streets);
            Conference c = new Conference(city, street, i);
            conferencesList.add(c.toString());
            startEndDates.add(c.getStartEndDates());
        }
    }

    public ArrayList<String> getConferencesList() {
        return conferencesList;
    }

    public ArrayList<String> getStartEndDates() {
        return startEndDates;
    }
}
