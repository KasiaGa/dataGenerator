import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Kasia on 2015-12-29.
 */
public class Main {

    public static void main(String args[]) {

        ClientsGenerator clientsGenerator = new ClientsGenerator();
        ConferenceGenerator conferenceGenerator = new ConferenceGenerator();
        ConferenceDateGenerator conferenceDateGenerator = new ConferenceDateGenerator();
        WorkshopsGenerator workshopsGenerator = new WorkshopsGenerator();
        ConferencePriceGenerator conferencePriceGenerator = new ConferencePriceGenerator();
        OrdersGenerator ordersGenerator = new OrdersGenerator();
        clientsGenerator.generateClientsAndCompanies();
        conferenceGenerator.generateConferences();
        conferenceDateGenerator.generateConferenceDate();
        workshopsGenerator.generateWorkshops();
        conferencePriceGenerator.generateConferencePrice();
        ordersGenerator.generateOrders();

        ArrayList<String> clients = clientsGenerator.getClientsList();
        ArrayList<String> companies = clientsGenerator.getCompaniesList();
        ArrayList<String> conferences = conferenceGenerator.getConferencesList();
        ArrayList<String> startEndDates = conferenceGenerator.getStartEndDates();
        ArrayList<String> conferenceDates = conferenceDateGenerator.getConferenceDateList();
        ArrayList<String> capacity = conferenceDateGenerator.getCapacityList();
        ArrayList<String> workshops = workshopsGenerator.getWorkshopsList();
        ArrayList<String> dates = conferenceDateGenerator.getDateList();
        ArrayList<String> conferencePrice = conferencePriceGenerator.getConferencePriceList();
        ArrayList<String> capacityAndDate = conferenceDateGenerator.getCapacityAndDate();
        ArrayList<String> capacityDateWorkshop = workshopsGenerator.getCapacityDateWorkshops();
        ArrayList<String> orders = ordersGenerator.getOrders();

        PrintWriter writerClients = null;
        PrintWriter writerCompanies = null;
        PrintWriter writerConferences = null;
        PrintWriter writerStartEndDates = null;
        PrintWriter writerConferenceDate = null;
        PrintWriter writerCapacity = null;
        PrintWriter writerWorkshops = null;
        PrintWriter writerDates = null;
        PrintWriter writerConferencePrice;
        PrintWriter writeCapacityAndDate;
        PrintWriter writeCapacityDateWorkshop;
        PrintWriter writeOrders;
        try {
            writerClients = new PrintWriter("output/clients.sql", "UTF-8");
            for(int i=0; i<clients.size(); i++) {
                //System.out.println(clients.get(i));
                writerClients.print(clients.get(i));
            }
            writerCompanies = new PrintWriter("output/companies.sql", "UTF-8");
            for(int i=0; i<companies.size(); i++) {
                //System.out.println(companies.get(i));
                writerCompanies.print(companies.get(i));
            }
            writerConferences = new PrintWriter("output/conferences.sql", "UTF-8");
            for(int i=0; i<conferences.size(); i++) {
                //System.out.println(conferences.get(i));
                writerConferences.print(conferences.get(i));
            }
            writerStartEndDates = new PrintWriter("output/startEndDates.sql", "UTF-8");
            for(int i=0; i<startEndDates.size(); i++) {
                //System.out.println(startEndDates.get(i));
                writerStartEndDates.print(startEndDates.get(i));
            }
            writerConferenceDate = new PrintWriter("output/conferenceDates.sql", "UTF-8");
            for(int i=0; i<conferenceDates.size(); i++) {
                //System.out.println(conferenceDates.get(i));
                writerConferenceDate.print(conferenceDates.get(i));
            }
            writerCapacity = new PrintWriter("output/capacity.sql", "UTF-8");
            for(int i=0; i<capacity.size(); i++) {
                //System.out.println(capacity.get(i));
                writerCapacity.print(capacity.get(i));
            }
            writerWorkshops = new PrintWriter("output/workshops.sql", "UTF-8");
            for(int i=0; i<workshops.size(); i++) {
                //System.out.println(workshops.get(i));
                writerWorkshops.print(workshops.get(i));
            }
            writerDates = new PrintWriter("output/dates.sql", "UTF-8");
            for(int i=0; i<dates.size(); i++) {
                //System.out.println(dates.get(i));
                writerDates.print(dates.get(i));
            }
            writerConferencePrice = new PrintWriter("output/conferencePrice.sql", "UTF-8");
            for(int i=0; i<conferencePrice.size(); i++) {
                //System.out.println(conferencePrice.get(i));
                writerConferencePrice.print(conferencePrice.get(i));
            }
            writeCapacityAndDate = new PrintWriter("output/capacityAndDate.sql", "UTF-8");
            for(int i=0; i<capacityAndDate.size(); i++) {
                //System.out.println(capacityAndDate.get(i));
                writeCapacityAndDate.print(capacityAndDate.get(i));
            }
            writeCapacityDateWorkshop = new PrintWriter("output/capacityDateWorkshop.sql", "UTF-8");
            for(int i=0; i<capacityDateWorkshop.size(); i++) {
                //System.out.println(capacityDateWorkshop.get(i));
                writeCapacityDateWorkshop.print(capacityDateWorkshop.get(i));
            }
            writeOrders = new PrintWriter("output/orders.sql", "UTF-8");
            for(int i=0; i<orders.size(); i++) {
                System.out.println(orders.get(i));
                writeOrders.print(orders.get(i));
            }
            writerClients.close();
            writerCompanies.close();
            writerConferences.close();
            writerStartEndDates.close();
            writerConferenceDate.close();
            writerCapacity.close();
            writerWorkshops.close();
            writerDates.close();
            writerConferencePrice.close();
            writeCapacityAndDate.close();
            writeCapacityDateWorkshop.close();
            writeOrders.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
