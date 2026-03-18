package account;

public class Main {

    public static void main(String[] args) {

        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);

        System.out.println("Current balance: " + account.getBalance());
        System.out.println("Monthly interest: " + account.getMonthlyInterest());
        System.out.println("Date created: " + account.getDateCreated());
        System.out.println();

        SavingAccount savingAccount = new SavingAccount(1022, 5000);
        savingAccount.setAnnualInterestRate(5);
        savingAccount.withdraw(4500);
        System.out.println();

        CheckingAccount checkingAccount = new CheckingAccount(1111, 500, 500);
        checkingAccount.withdraw(1100);

    }
}
