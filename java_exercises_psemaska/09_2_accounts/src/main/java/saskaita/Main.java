package saskaita;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList<Bank> banks = new ArrayList<>();

        DebitAccount debitAccount = new DebitAccount(1234, "Jonas");
        CreditAccount creditAccount = new CreditAccount(debitAccount, 500);
        banks.add(debitAccount);
        banks.add(creditAccount);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter bank account number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        boolean proceed = false;
        for(Bank bank : banks){
            if(bank.getAccountNumer() == accountNumber){
                proceed = true;
                break;
            }
        }

        if(!proceed){
            System.out.println("Bank account doesn't exist");
        }

        while(proceed) {

            System.out.println("Which account would you like to use (debit/credit)? ");
            String accountType = scanner.nextLine();

            for(Bank bank : banks){

                if(bank.getAccountNumer() == accountNumber && accountType.equals("debit") && bank instanceof DebitAccount) {
                    ((DebitAccount) bank).proceedOperation(bank);
                    break;
                } else if(bank.getAccountNumer() == accountNumber && accountType.equals("credit") && bank instanceof CreditAccount) {
                    ((CreditAccount) bank).proceedOperation(bank);
                    break;
                }
            }

            System.out.println("Would you like to continue (y/n)? ");
            String answer = scanner.nextLine();
            if(!answer.equals("y")){
                scanner.close();
                proceed = false;
            }


        }









    }

}
