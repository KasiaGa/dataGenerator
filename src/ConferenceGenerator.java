import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-15.
 */
public class ConferenceGenerator {

    Generator generator = new Generator();
    ArrayList<String> conferenceNames;
    ArrayList<String> cities;
    ArrayList<String> streets;

    ArrayList<String> conferencesList;

    public ConferenceGenerator() {
        //this.conferenceNames = generator.readFile("data/conferences.txt");
        this.cities = generator.readFile("data/cities.txt");
        this.streets = generator.readFile("data/streets.txt");

        conferencesList = new ArrayList<>();
    }

    public void generateConferences() {
        for(int i=0; i<200; i++) {
            String conferenceName = generator.select(conferenceNames);
            String city = generator.select(cities);
            String street = generator.select(streets);
            conferencesList.add(new Conference(conferenceName, city, street).toString());
        }
    }

    public ArrayList<String> getConferencesList() {
        return conferencesList;
    }
}
