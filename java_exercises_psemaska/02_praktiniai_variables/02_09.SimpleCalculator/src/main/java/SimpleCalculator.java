
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        String num1 = scanner.nextLine();

        System.out.println("Give the second number:");
        String num2 = scanner.nextLine();

        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
        System.out.println(num1 + " + " + num2 + " = " + sum);

        int sub = Integer.parseInt(num1) - Integer.parseInt(num2);
        System.out.println(num1 + " - " + num2 + " = " + sub);

        int mul = Integer.parseInt(num1) * Integer.parseInt(num2);
        System.out.println(num1 + " * " + num2 + " = " + mul);

        double div = Double.parseDouble(num1) / Double.parseDouble(num2);
        System.out.println(num1 + " / " + num2 + " = " + div);

    }
}
