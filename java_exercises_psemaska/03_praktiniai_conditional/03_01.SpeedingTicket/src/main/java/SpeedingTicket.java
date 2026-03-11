
import java.sql.SQLOutput;
import java.util.Scanner;

public class SpeedingTicket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = Integer.parseInt(scanner.nextLine());

        if(num > 120){
            System.out.println("Speeding ticket!");
        }

    }
}
