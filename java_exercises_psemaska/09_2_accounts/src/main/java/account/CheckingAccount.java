package account;

public class CheckingAccount extends Account{

    private double maxCredit;

    public CheckingAccount(double maxCredit) {
        this.maxCredit = maxCredit;
    }

    public CheckingAccount(int id, double balance, double maxCredit) {
        super(id, balance);
        this.maxCredit = maxCredit;
    }

    public double getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(double maxCredit) {
        this.maxCredit = maxCredit;
    }

    @Override
    public void withdraw(int amount) {
        if((getBalance() + maxCredit) >= amount) {
            this.setBalance(getBalance() - amount);
            System.out.println("Success!");
            System.out.println("Your balance is: " + getBalance());
        } else {
            System.out.println("Not enough money in your bank account.");
            System.out.println("Your balance with credit is: " + (getBalance() + maxCredit));
        }
    }
}
