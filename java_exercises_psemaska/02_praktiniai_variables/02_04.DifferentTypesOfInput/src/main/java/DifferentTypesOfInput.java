
import java.util.Scanner;

public class DifferentTypesOfInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a string:");
        String myString = scanner.nextLine();

        System.out.println("Give an integer:");
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println("Give a double:");
        double myDouble = Double.parseDouble(scanner.nextLine());

        System.out.println("Give a boolean:");
        boolean myBool = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("You gave the string " + myString);
        System.out.println("You gave the integer " + num);
        System.out.println("You gave the double " + myDouble);
        System.out.println("You gave the boolean " + myBool);

    }
}
