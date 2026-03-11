
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numArray = new ArrayList<>();

        System.out.println("Give the first number:");
        int num1 = Integer.parseInt(scanner.nextLine());
        numArray.add(num1);

        System.out.println("Give the second number:");
        int num2 = Integer.parseInt(scanner.nextLine());
        numArray.add(num2);

        System.out.println("Give the third number:");
        int num3 = Integer.parseInt(scanner.nextLine());
        numArray.add(num3);

        double result = (double) (num1 + num2 + num3) / numArray.size();

        System.out.println("The average is " + result);

    }
}
