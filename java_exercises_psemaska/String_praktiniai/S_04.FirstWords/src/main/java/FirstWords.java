
import java.util.Scanner;

public class FirstWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            if(!input.isEmpty()){
                String[] inputs = input.split(" ");
                System.out.println(inputs[0]);
            } else {
                break;
            }


        }

    }
}
