package saskaita;

import java.util.Scanner;

public class DebitAccount extends Bank {

    private int balance;

    public DebitAccount(int accountNumber, String name) {
        super(accountNumber, name);
        this.balance = 0;
    }

    public DebitAccount(int accountNumber, String name, int balance) {
        super(accountNumber, name);
        this.balance = balance;
    }

    public void debit(int amount) {
        balance += amount;
        System.out.println("Money added successfully");
    }

    public void credit(int amount) {
        if(balance >= amount){
            balance -= amount;
        } else {
            System.out.println("Not enough money in bank account");
        }
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void proceedOperation(Bank bank) {

        Scanner scanner = new Scanner(System.in);
        DebitAccount debitAccount = (DebitAccount) bank;

        System.out.println("What operation would you like to proceed (add/take)?");
        String operation = scanner.nextLine();
        if(operation.equals("add")){
            System.out.println("Enter amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            debitAccount.debit(amount);
            System.out.println("Account balance: " + debitAccount.getBalance());
        } else {
            System.out.println("Enter amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            debitAccount.credit(amount);
            System.out.println("Account balance: " + debitAccount.getBalance());
        }

    }




}
