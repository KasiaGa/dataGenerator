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
        clientsGenerator.generateClientsAndCompanies();
        conferenceGenerator.generateConferences();
        conferenceDateGenerator.generateConferenceDate();

        ArrayList<String> clients = clientsGenerator.getClientsList();
        ArrayList<String> companies = clientsGenerator.getCompaniesList();
        ArrayList<String> conferences = conferenceGenerator.getConferencesList();
        ArrayList<String> startEndDates = conferenceGenerator.getStartEndDates();
        ArrayList<String> conferenceDates = conferenceDateGenerator.getConferenceDateList();
        ArrayList<String> capacity = conferenceDateGenerator.getCapacityList();

        PrintWriter writerClients = null;
        PrintWriter writerCompanies = null;
        PrintWriter writerConferences = null;
        PrintWriter writerStartEndDates = null;
        PrintWriter writerConferenceDate = null;
        PrintWriter writerCapacity = null;
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
                System.out.println(conferences.get(i));
                writerConferences.print(conferences.get(i));
            }
            writerStartEndDates = new PrintWriter("output/startEndDates.sql", "UTF-8");
            for(int i=0; i<startEndDates.size(); i++) {
                //System.out.println(startEndDates.get(i));
                writerStartEndDates.print(startEndDates.get(i));
            }
            writerConferenceDate = new PrintWriter("output/conferenceDates.sql", "UTF-8");
            for(int i=0; i<conferenceDates.size(); i++) {
                System.out.println(conferenceDates.get(i));
                writerConferenceDate.print(conferenceDates.get(i));
            }
            writerCapacity = new PrintWriter("output/capacity.sql", "UTF-8");
            for(int i=0; i<capacity.size(); i++) {
                System.out.println(capacity.get(i));
                writerCapacity.print(capacity.get(i));
            }
            writerClients.close();
            writerCompanies.close();
            writerConferences.close();
            writerStartEndDates.close();
            writerConferenceDate.close();
            writerCapacity.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
