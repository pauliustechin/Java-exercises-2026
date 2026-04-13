
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter

        Scanner scan = new Scanner(System.in);
        Observation observation = new Observation(scan);

        boolean run = true;
        while (run) {
            System.out.print("? ");
            String answer = scan.nextLine();

            switch (answer.toLowerCase()) {
                case ("add"):
                    observation.add();
                    break;
                case ("observation"):
                    observation.observation();
                    break;
                case ("all"):
                    observation.all();
                    break;
                case ("one"):
                    observation.one();
                    break;
                case ("quit"):
                    scan.close();
                    run = false;
                    break;
                default:
                    System.out.println("Command not found. Try again");
            }
        }
    }

}
