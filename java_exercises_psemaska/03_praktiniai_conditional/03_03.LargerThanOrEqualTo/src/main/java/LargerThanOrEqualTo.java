
import java.util.Scanner;

public class LargerThanOrEqualTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give the first number: ");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Give the second number: ");
        int num2 = Integer.parseInt(scan.nextLine());

        if(num1 > num2){
            System.out.println("Greater number is: " + num1);
        } else if(num2 > num1){
            System.out.println("Greater number is: " + num2);
        } else {
            System.out.println("The numbers are equal!");
        }
    }
}
