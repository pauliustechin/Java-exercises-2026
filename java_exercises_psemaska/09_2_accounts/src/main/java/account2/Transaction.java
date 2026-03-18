package account2;

import java.util.Date;

public class Transaction {

    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(Date date, char type, double amount, double balance) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
