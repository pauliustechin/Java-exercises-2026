
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            if(!input.isEmpty()){
                String[] inputs = input.split(" ");
                for(String s : inputs){
                    System.out.println(s);
                }
            } else {
                break;
            }


        }
    }
}
