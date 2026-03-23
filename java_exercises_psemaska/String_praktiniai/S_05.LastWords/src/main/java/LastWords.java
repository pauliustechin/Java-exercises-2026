
import java.util.Scanner;

public class LastWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            if(!input.isEmpty()){
                String[] inputs = input.split(" ");
                System.out.println(inputs[inputs.length - 1]);

            } else {
                break;
            }


        };


    }
}
