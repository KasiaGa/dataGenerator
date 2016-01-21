import java.util.ArrayList;

/**
 * Created by Kasia on 2016-01-21.
 */
public class OrdersGenerator {

    Generator generator = new Generator();
    ArrayList<String> orders = new ArrayList<>();
    ArrayList<String> capacityDateWorkshop;

    public OrdersGenerator() {
        this.capacityDateWorkshop = generator.readFile("output/capacityDateWorkshop.sql");
    }

    public void generateOrders() {
        int counter = 1;
        int clientsCounter = 1;
        int workshopsCounter = 1;
        for(String cdw: capacityDateWorkshop) {
            Orders o = new Orders(counter, clientsCounter, workshopsCounter, cdw);
            counter++;
            clientsCounter = o.getClientsCounter();
            workshopsCounter = o.getWorkshopsCounter();
            orders.add(o.toString());
        }
    }

    public ArrayList<String> getOrders() {
        return orders;
    }
}
