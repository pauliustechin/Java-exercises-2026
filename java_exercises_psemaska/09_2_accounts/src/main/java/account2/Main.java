package account2;

public class Main {

    public static void main(String[] args) {

        Account account = new Account(1122, 20000, "Jonas");
        account.withdraw(1500);
        account.withdraw(500);
        account.deposit(1000);
        System.out.println(account);
        System.out.println();
        System.out.println("Transactions: " + account.getAllTransactions());
    }
}
