package account;

import java.text.DateFormat;
import java.util.Date;

public class Account {

    private int id;
    private double balance = 0;
    private double annualInterestRate = 0;
    private final String dateCreated;

    private final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    private final String date = dateFormat.format(new Date());

    public Account() {
        this.dateCreated = date;
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
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
        }

    }





}
