package account;

public class Main {

    public static void main(String[] args){

        Account account1 = new Account("1", "Jonas", 1000);
        Account account2 = new Account("2", "Egle");

        account1.credit(1200);
        account1.debit(500);

        int balance = account1.transferTo(account2, 600);

        System.out.println("acc1 balance:" + balance);

        System.out.println("acc2 balance:" + account2.getBalance());
    }
}
