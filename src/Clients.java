import java.util.Random;
import java.util.UUID;

/**
 * Created by Kasia on 2015-12-28.
 */
public class Clients {

    private String companyID;
    private String name;
    private String lastName;
    private String city;
    private String street;
    private int localNumber;
    private String postalCode;
    private String mail;

    public Clients(String companyID, String name, String lastName, String city, String street) {

        Random random = new Random();

        this.companyID = companyID;
        this.name = name;
        this.lastName = lastName;
        this.lastName = fixLastName(name, lastName);
        this.city = city;
        this.street = street;
        this.localNumber = random.nextInt(199)+1;
        this.postalCode = String.valueOf((random.nextInt(90)+10)) + '-' + String.valueOf(random.nextInt(900)+100);
        this.mail = generateEmail(name, this.lastName);

    }

    public String fixLastName(String name, String lastName) {
        StringBuilder newLastName = new StringBuilder();
        if(name.endsWith("a") && lastName.endsWith("i")) {
            for(int i=0; i<lastName.length()-1; i++) {
                newLastName.append(lastName.charAt(i));
            }
            newLastName.append("a");
            return newLastName.toString();
        }
        return lastName;
    }

    public String generateEmail(String name, String lastName) {
        Random random = new Random();
        String[] domain = {"gmail.com", "interia.pl", "onet.pl", "wp.pl"};
        String mailName = name + lastName;
        mailName = mailName.toLowerCase();
        mailName = mailName.replace('ą', 'a').replace('ę', 'e').replace('ó', 'o').replace('ł', 'l').replace('ń', 'n').
            replace('ś', 's').replace('ż', 'z').replace('ź', 'z').replace('ć', 'c');
        mailName = mailName + '@' + domain[random.nextInt(domain.length)];
        return mailName;
    }

    public String toString() {
        return "exec addClient " + this.companyID + ", '" + this.name + "', '" + this.lastName + "', '" + this.mail + "', '" +
                this.city + "', '" + this.postalCode + "', '" + this.street + "', '" + this.localNumber + "'" + '\n';
    }

}
