import java.util.Random;

/**
 * Created by Kasia on 2015-12-28.
 */
public class Companies {

    private String companyName;
    private String nip;

    public Companies(String companyName) {
        this.companyName = companyName;
        this.nip = generateNip();
    }

    public String generateNip() {
        Random random = new Random();
        StringBuilder nip = new StringBuilder("");
        for(int i=0; i<10; i++) {
            nip.append(String.valueOf(random.nextInt(10)));
        }
        return nip.toString();
    }

    public String toString() {
        return "exec AddCompany '" + this.companyName + "', '" + this.nip + "'" + '\n';
    }
}
