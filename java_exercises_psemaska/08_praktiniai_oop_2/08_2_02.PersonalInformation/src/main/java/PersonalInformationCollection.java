
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();

            if(firstName.isEmpty()){
                break;
            }

            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();

            System.out.println("Enter identification number: ");
            String identificationNumber = scanner.nextLine();

            infoCollection.add(new PersonalInformation(firstName, lastName, identificationNumber));

            }

        for(PersonalInformation personalInformation : infoCollection){
            System.out.println(personalInformation.getFirstName() + " " + personalInformation.getLastName());

        }



    }
}
