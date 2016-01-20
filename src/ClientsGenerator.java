import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Kasia on 2015-12-28.
 */
public class ClientsGenerator {

    Generator generator = new Generator();
    ArrayList<String> companies;
    ArrayList<String> names;
    ArrayList<String> lastNames;
    ArrayList<String> cities;
    ArrayList<String> streets;
    ArrayList<String> clientsList;
    ArrayList<String> companiesList;
    ArrayList<String> companyID;

    public ClientsGenerator() {

        this.companies = generator.readFile("data/companies.txt");
        this.names = generator.readFile("data/names.txt");
        this.lastNames = generator.readFile("data/lastnames.txt");
        this.cities = generator.readFile("data/cities.txt");
        this.streets = generator.readFile("data/streets.txt");
        this.companyID = new ArrayList<>(72);
        fillIDs();

        clientsList = new ArrayList<>();
        companiesList = new ArrayList<>();
    }

    public void fillIDs() {
        Random random = new Random();
        for(int i=0; i<72; i++) {
            companyID.add("NULL");
        }

        int rand;

        for(int i=1; i<=40; i++) {
            do {
                rand = random.nextInt(72);
            }
            while(!companyID.get(rand).equals("NULL"));
            companyID.set(rand, String.valueOf(i));
        }

        /*for(int i=0; i<72; i++) {
            System.out.print(companyID.get(i) + " ");
        }*/
    }

    public void generateClientsAndCompanies() {
        for(int i=0; i<30; i++) {
            String company = generator.select(companies);
            companiesList.add(new Companies(company).toString());
        }

        for(int i=0; i<50; i++) {
            String name = generator.select(names);
            String lastName = generator.select(lastNames);
            String city = generator.select(cities);
            String street = generator.select(streets);
            String compID = generator.select(companyID);
            clientsList.add(new Clients(compID, name, lastName, city, street).toString());
        }
    }

    public ArrayList<String> getClientsList() {
        return clientsList;
    }

    public ArrayList<String> getCompaniesList() {
        return  companiesList;
    }
}
