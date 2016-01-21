import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-21.
 */
public class WorkshopsGenerator {

    Generator generator = new Generator();
    ArrayList<String> capacity;
    ArrayList<String> workshopsList = new ArrayList<>();

    public WorkshopsGenerator() {
        this.capacity = generator.readFile("output/capacity.sql");
    }

    public void generateWorkshops() {
        int counter = 1;
        for(String c: capacity) {
            Workshops w = new Workshops(counter, Integer.parseInt(c));
            counter++;
            workshopsList.add(w.toString());
        }
    }

    public ArrayList<String> getWorkshopsList() {
        return workshopsList;
    }

}
