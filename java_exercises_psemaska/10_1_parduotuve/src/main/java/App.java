import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args){

        while(true){
            Scanner scanner = new Scanner(System.in);
            List<Parduotuve> prekes = new ArrayList<>();
            System.out.println("Pridėkite prekę. ");

            while(true){
                System.out.println("Įveskite prekės tipą (preke, vaistas, alkoholis, vynas): ");
                String type = scanner.nextLine();
                checkType(type, prekes);
                System.out.println("Ar norite prideti dar viena preke (y/n)?");
                String answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("y")) {
                    break;
                }
            }

            if(!prekes.isEmpty()){
                System.out.println(prekes);
                break;
            } else {
                System.out.println("Prekiu parduotuveje nera.");
            }

        }

    }

    public static void checkType(String type, List prekes){

        Scanner scanner = new Scanner(System.in);
        switch (type){
            case "preke":
                System.out.println("Įveskite prekes pavadinima: ");
                String name = scanner.nextLine();
                System.out.println("Ivekite prekes kaina: ");
                double kaina  = Double.parseDouble(scanner.nextLine());
                Parduotuve preke = new Preke(name, kaina);
                prekes.add(preke);
                break;
            case "vaistas":
                System.out.println("Įveskite prekes pavadinima: ");
                String medicineName = scanner.nextLine();
                System.out.println("Ivekite prekes kaina: ");
                double medicinePrice  = Double.parseDouble(scanner.nextLine());
                Parduotuve vaistas = new Vaistas(medicineName, medicinePrice);
                prekes.add(vaistas);
            case "alkoholis":
                System.out.println("Įveskite prekes pavadinima: ");
                String alkName = scanner.nextLine();
                System.out.println("Ivekite prekes kaina: ");
                double alkPrice  = Double.parseDouble(scanner.nextLine());
                System.out.println("Ivekite kiekį: ");
                double volume = Double.parseDouble(scanner.nextLine());
                System.out.println("Ivekite alk tūrį: ");
                double alkVolume  = Double.parseDouble(scanner.nextLine());
                Parduotuve alkoholis = new Alkoholis(alkName, alkPrice, volume, alkVolume);
                prekes.add(alkoholis);
            case "vynas":
                System.out.println("Įveskite prekes pavadinima: ");
                String vynName = scanner.nextLine();
                System.out.println("Ivekite prekes kaina: ");
                double vynPrice  = Double.parseDouble(scanner.nextLine());
                System.out.println("Ivekite kiekį: ");
                double vynVolume = Double.parseDouble(scanner.nextLine());
                System.out.println("Ivekite alk tūrį: ");
                double vynAlkVolume  = Double.parseDouble(scanner.nextLine());
                Parduotuve vynas = new Alkoholis(vynName, vynPrice, vynVolume, vynAlkVolume);
                prekes.add(vynas);
        }
    }






}
