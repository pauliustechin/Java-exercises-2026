
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Value of the gift?");
        int giftValue = Integer.parseInt(scan.nextLine());

        if(giftValue < 5000){
            System.out.println("No tax!");
        } else if(giftValue < 25000){
            int taxMinVal = 5000;
            int tax = 100;
            double taxRate = 0.08;
            double total = (tax + ((giftValue - taxMinVal) * taxRate));
            System.out.println("Tax: " + total);
        } else if(giftValue < 55000){
            int taxMinVal = 25000;
            int tax = 1700;
            double taxRate = 0.1;
            double total = (tax + ((giftValue - taxMinVal) * taxRate));
            System.out.println("Tax: " + total);
        } else if(giftValue < 200000){
            int taxMinVal = 55000;
            int tax = 4700;
            double taxRate = 0.12;
            double total = (tax + ((giftValue - taxMinVal) * taxRate));
            System.out.println("Tax: " + total);
        } else if(giftValue < 1000000){
            int taxMinVal = 200000;
            int tax = 22100;
            double taxRate = 0.15;
            double total = (tax + ((giftValue - taxMinVal) * taxRate));
            System.out.println("Tax: " + total);
        } else {
            int taxMinVal = 1000000;
            int tax = 142100;
            double taxRate = 0.17;
            double total = (tax + ((giftValue - taxMinVal) * taxRate));
            System.out.println("Tax: " + total);
        }
    }
}
