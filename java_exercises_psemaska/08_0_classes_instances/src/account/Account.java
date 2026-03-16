package account;

public class Account {

    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount){
        if(amount <= balance){
            balance = balance - amount;
            return balance;
        } else {
            System.out.println("Transfer amount exceeded balance");
            return balance;
        }
    }

    public int debit(int amount){
        balance = balance + amount;
        return balance;
    }

    public int transferTo(Account account, int amount){
        if(amount <= balance){
            account.debit(amount);
            balance = balance - amount;
            return balance;
        } else {
            System.out.println("Amount exceeded balance");
            return balance;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
