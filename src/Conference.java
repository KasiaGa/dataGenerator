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
    private String startDate;
    private String endDate;

    public Conference(String city, String street, int counter) {
        Random random = new Random();
        this.conferenceName = "Conference" + String.valueOf(counter);
        this.city = city;
        this.postalCode = String.valueOf((random.nextInt(90)+10)) + '-' + String.valueOf(random.nextInt(900)+100);
        this.street = street;
        this.localNumber = random.nextInt(199)+1;
        generateDate();
    }

    public void generateDate() {
        Random r = new Random();
        boolean alreadySet = false;
        int[] date = new int[3];
        int yearNumber = r.nextInt(2);
        date[0] = 2013 + yearNumber;
        int month = r.nextInt(12)+1;
        date[1] = month;
        int day;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = r.nextInt(31) + 1;
        }
        else if(month == 2) {
            day = r.nextInt(28) + 1;
        }
        else {
            day = r.nextInt(30) + 1;
        }

        date[2] = day;

        int[] endDateArray = new int[3];
        day = r.nextInt(2)+2;
        if((date[2] + day) > 28) {
            if(date[1] == 2) { // jak jest luty
                endDateArray[2] = (date[2] + day)%28;
                endDateArray[1] = date[1] + 1;
                endDateArray[0] = date[0];
                alreadySet = true;
            }
        }
        if((date[2] + day) > 30) {
            if(date[1] == 4 || date[1] == 6 || date[1] == 9 || date[1] == 11) {
                endDateArray[2] = (date[2] + day)%30;
                endDateArray[1] = date[1] + 1;
                endDateArray[0] = date[0];
                alreadySet = true;
            }
        }
        if((date[2] + day) > 31 && ((date[1] == 1 || date[1] == 3 || date[1] == 5 || date[1] == 7 || date[1] == 8 || date[1] == 10 || date[1] == 12))) {
            if(date[1] == 12) {
                endDateArray[2] = (date[2] + day)%31;
                endDateArray[1] = 1;
                endDateArray[0] = date[0] + 1;
                alreadySet = true;
            }
            else {
                endDateArray[2] = (date[2] + day)%31;
                endDateArray[1] = date[1] + 1;
                endDateArray[0] = date[0];
                alreadySet = true;
            }
        }
        else if((date[2] + day) <32 && !alreadySet) {
            endDateArray[2] = date[2] + day;
            endDateArray[1] = date[1];
            endDateArray[0] = date[0];
        }

            System.out.println(endDateArray[0] + " " + endDateArray[1] + " " + endDateArray[2]);


        this.startDate = date[0] + "-" + date[1]/10 + date[1]%10 + "-" + date[2]/10 + date[2]%10;
        this.endDate = endDateArray[0] + "-" + endDateArray[1]/10 + endDateArray[1]%10 + "-" + endDateArray[2]/10 + endDateArray[2]%10;

    }

    public String toString() {
        return "exec AddConference '" + this.conferenceName + "', '" + this.city + "', '" + this.postalCode + "', '" +
                this.street + "', " + this.localNumber + ", '" + this.startDate + "', '" + this.endDate + "'" + '\n';
    }

    public String getStartEndDates() {
        return this.startDate + " " + this.endDate + '\n';
    }
}
