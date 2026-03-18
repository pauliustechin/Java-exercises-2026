package saskaita;

import java.util.Scanner;

public class CreditAccount extends Bank {

    private int maxCredit;

    public CreditAccount(DebitAccount debitAccount, int maxCredit) {
        super(debitAccount.getAccountNumer(), debitAccount.getName());
        this.maxCredit = maxCredit;
    }

    public void credit(int amount) {
        if(maxCredit >= amount){
            maxCredit -= amount;
            System.out.println("You have left " + maxCredit + " in your credit account");
        } else {
            System.out.println("Not enough money in your credit account.");
        }
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    @Override
    public void proceedOperation(Bank bank) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount to take from credit card: ");
        int amount = Integer.parseInt(scanner.nextLine());
        ((CreditAccount) bank).credit(amount);
        System.out.println("You can borrow: " + this.getMaxCredit());
    }
}
