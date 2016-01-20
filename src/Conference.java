import java.util.Random;

/**
 * Created by Kasia on 2015-12-29.
 */
public class Conference {

    private String conferenceName;
    private String city;
    private String postalCode;
    private String street;
    private int localNumber;

    public Conference(String conferenceName, String city, String street) {
        Random random = new Random();
        this.conferenceName = conferenceName;
        this.city = city;
        this.postalCode = String.valueOf((random.nextInt(90)+10)) + '-' + String.valueOf(random.nextInt(900)+100);
        this.street = street;
        this.localNumber = random.nextInt(199)+1;
    }

    public String toString() {
        return "exec addConference '" + this.conferenceName + "', '" + this.city + "', '" + this.postalCode + "', '" +
                this.street + "', " + localNumber + '\n';
    }
}
