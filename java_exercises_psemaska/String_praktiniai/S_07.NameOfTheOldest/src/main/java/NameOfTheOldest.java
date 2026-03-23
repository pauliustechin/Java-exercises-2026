
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String oldestName = "";
        int oldest = 0;

        while (true) {

            System.out.println("Enter name and age separated by comma: ");
            String nameAndAge = scanner.nextLine();

            if(!nameAndAge.isEmpty()){
                String[] info = nameAndAge.split(",");
                int age = Integer.parseInt(info[1]);
                if(oldest < age){
                    oldest = age;
                    oldestName = info[0];
                }

            } else {
                break;
            }
        }
        System.out.println("Name of the oldest: " + oldestName);

    }
}
