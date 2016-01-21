package test;

import java.util.Random;

/**
 * Created by Kasia on 2016-01-21.
 */
public class DateGeneratorTest {

    private static String startDate;
    private static String endDate;

    public static void generateDate(String startDateString) {
        Random r = new Random();
        int[] date = new int[3];
        int day;
        boolean alreadySet = false;

        date[0] = 1000*(startDateString.charAt(0)-48) + 100*(startDateString.charAt(1)-48) + 10 * (startDateString.charAt(2)-48) +
                startDateString.charAt(3)-48;
        date[1] = 10 * (startDateString.charAt(5)-48) + startDateString.charAt(6)-48;
        date[2] = 10 * (startDateString.charAt(8)-48) + startDateString.charAt(9)-48;

        System.out.println(date[0] + " " + date[1] + " " + date[2]);

        int[] endDateArray = new int[3];
        day = r.nextInt(2)+2;

        System.out.println(day);

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

        startDate = date[0] + "-" + date[1]/10 + date[1]%10 + "-" + date[2]/10 + date[2]%10;
        endDate = endDateArray[0] + "-" + endDateArray[1]/10 + endDateArray[1]%10 + "-" + endDateArray[2]/10 + endDateArray[2]%10;
    }

    public static void main(String[] args) {
        startDate = "2014-02-27";
        System.out.println(startDate);
        generateDate(startDate);
        System.out.println(endDate);
    }
}
