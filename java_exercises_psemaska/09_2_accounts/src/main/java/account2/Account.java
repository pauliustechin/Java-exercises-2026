package account2;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Account {

    private int id;
    private double balance = 0;
    private double annualInterestRate = 0;
    private final String dateCreated;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    private final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    private final String date = dateFormat.format(new Date());

    public Account(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.dateCreated = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyInterestRate() {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        return monthlyInterestRate;
    }

    public double getMonthlyInterest() {
        double monthlyInterest = balance * this.getMonthlyInterestRate();
        return monthlyInterest;
    }

    public void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Success!");
            System.out.println("Your balance is: " + balance);
            Transaction transaction = new Transaction(new Date(), 'W', amount, balance);
            transactions.add(transaction);
        } else {
            System.out.println("Not enough money in your bank account.");
            System.out.println("Your balance is: " + balance);
        }
    }

    public void deposit(int amount) {
        if(amount > 0){
            balance += amount;
            System.out.println("Money added successfully.");
            System.out.println("Your balance is: " + balance);
            Transaction transaction = new Transaction(new Date(), 'D', amount, balance);
            transactions.add(transaction);
        }
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
