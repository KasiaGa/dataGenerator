import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-21.
 */
public class WorkshopsGenerator {

    Generator generator = new Generator();
    ArrayList<String> capacity;
    ArrayList<String> workshopsList = new ArrayList<>();
    ArrayList<String> capacityAndDate;
    ArrayList<String> capacityDateWorkshops = new ArrayList<>();

    public WorkshopsGenerator() {
        this.capacity = generator.readFile("output/capacity.sql");
        this.capacityAndDate = generator.readFile("output/capacityAndDate.sql");
    }

    public void generateWorkshops() {
        int counter = 1;
        for(String c: capacity) {
            Workshops w = new Workshops(counter, Integer.parseInt(c), capacityAndDate.get(counter-1));
            counter++;
            workshopsList.add(w.toString());
            capacityDateWorkshops.add(w.getCapacityDateWorkshop());
        }
    }

    public ArrayList<String> getWorkshopsList() {
        return workshopsList;
    }

    public ArrayList<String> getCapacityDateWorkshops() {
        return capacityDateWorkshops;
    }

}
