import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kasia on 2016-01-21.
 */
public class Orders {

    private int clientID;
    private int conferenceDateID;
    private int workshopDateID;
    private int[] orderDate = new int[3];
    private int amount;
    private String payment = "null";
    StringBuilder result = new StringBuilder();
    private int clientsCounter;
    private int workshopsCounter;

    public Orders(int conferenceDate, int clientsCounter, int workshopsCounter, String capacityAndDate) {
        Random random = new Random();
        String data[] = capacityAndDate.split(" ");
        int wholeCapacity = Integer.parseInt(data[0]);
        String date = data[1];
        this.orderDate[0] = 1000*(date.charAt(0)-48) + 100*(date.charAt(1)-48) + 10 * (date.charAt(2)-48) + date.charAt(3)-48;
        this.orderDate[1] = 10 * (date.charAt(5)-48) + date.charAt(6)-48;
        this.orderDate[2] = 10 * (date.charAt(8)-48) + date.charAt(9)-48;
        ArrayList<Integer> workshopCapacities = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if(i>=2) {
                workshopCapacities.add(Integer.parseInt(data[i]));
            }
        }
        this.conferenceDateID = conferenceDate;
        this.clientsCounter = clientsCounter;
        this.workshopDateID = workshopsCounter;

        /*int numberOfOrders = random.nextInt(4)+1;
        for(int i=0; i<numberOfOrders; i++) {
            result.append("exec AddOrder ").append()
        }*/

        while(wholeCapacity>=50) {
            result.append("exec AddOrder ").append(clientsCounter).append(", ").append(this.conferenceDateID).append(", null, ");
            int numberOfMonths = random.nextInt(4)+1;
            int[] oDate = new int[3];
            oDate[2] = orderDate[2];
            if(oDate[1]-numberOfMonths<0) {
                int dif = Math.abs(oDate[1] - numberOfMonths);
                oDate[1] = 12 - dif;
                oDate[0] = orderDate[0]-1;
            }
            else {
                oDate[1]-=numberOfMonths;
                oDate[0] = orderDate[0];
            }
            result.append(oDate[0] + "-" + oDate[1] / 10 + oDate[1] % 10 + "-" + oDate[2] / 10 + oDate[2] % 10).append(", ");

            int newAmount = random.nextInt(3)*10+30;
            result.append(newAmount).append(", ");

            wholeCapacity -= newAmount;

            result.append("null, ");

            int studentsAmount = random.nextInt(newAmount);

            result.append(studentsAmount).append("\n");

            int numberOfOrders;
            if(workshopCapacities.size()!=0) {
                numberOfOrders = random.nextInt(workshopCapacities.size());
            }
            else numberOfOrders = 0;

            for(int i=0; i<numberOfOrders; i++) {
                result.append("exec AddOrder ").append(clientsCounter).append(", null, ");
                int whichWorkshop = random.nextInt(workshopCapacities.size());
                int workshopID = workshopsCounter + whichWorkshop;
                result.append(workshopID).append(", ").append(oDate[0] + "-" + oDate[1]/10 + oDate[1]%10 + "-" +oDate[2]/10 + oDate[2]%10).append(", ");
                newAmount = Math.min(random.nextInt(wholeCapacity/numberOfOrders + 1), workshopCapacities.get(i));
                result.append(newAmount).append(", ");
                wholeCapacity-=newAmount;

                result.append("null, ");

                studentsAmount = Math.min(random.nextInt(studentsAmount/numberOfOrders + 1), newAmount);
                result.append(studentsAmount).append("\n");
            }
            this.clientsCounter++;
            if(this.clientsCounter%73 == 0) {
                this.clientsCounter = 1;
            }
            this.workshopsCounter+=workshopCapacities.size();
        }

    }

    public int getClientsCounter() {
        return this.clientsCounter;
    }

    public int getWorkshopsCounter() {
        return this.workshopsCounter;
    }

    public String toString() {
        return result.toString();
    }


}
