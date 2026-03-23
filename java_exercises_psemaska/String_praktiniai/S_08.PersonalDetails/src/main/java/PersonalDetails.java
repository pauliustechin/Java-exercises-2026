
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String longestName = "";
        double birthYearSum = 0;
        int count = 0;


        while (true) {

            System.out.println("Enter name and birth year separated by comma: ");
            String nameAndAge = scanner.nextLine();

            if(!nameAndAge.isEmpty()){
                count++;
                String[] info = nameAndAge.split(",");
                double birthYear = Double.parseDouble(info[1]);
                birthYearSum += birthYear;
                if(longestName.length() < info[0].length()) {
                    longestName = info[0];
                }
            } else {
                break;
            }
        }
        double avgOfBirthYear = birthYearSum / count;
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + avgOfBirthYear);


    }
}
