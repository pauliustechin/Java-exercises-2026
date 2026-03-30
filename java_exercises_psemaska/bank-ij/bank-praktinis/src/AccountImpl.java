import ibank.Account;
import java.math.BigDecimal;
import java.util.UUID;


public class AccountImpl implements Account {

    private String holderName;
    private UUID number;
    private BigDecimal balance;
    private BigDecimal credit = BigDecimal.ZERO;

    public AccountImpl(String holderName) {
        this.holderName = holderName;
        this.number = UUID.randomUUID();
        this.balance = BigDecimal.ZERO;
    }

    public AccountImpl(String holderName, BigDecimal credit) {
        this.holderName = holderName;
        this.number = UUID.randomUUID();
        this.balance = BigDecimal.ZERO;
        this.credit = this.credit.add(credit);
    }

    @Override
    public String getNumber() {
        return String.valueOf(number);
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        balance = balance.add(bigDecimal);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal bigDecimal) {

        BigDecimal total = BigDecimal.ZERO;
        total = total.add(balance);
        total = total.add(credit);

        if(total.compareTo(bigDecimal) >= 0) {
            balance = balance.subtract(bigDecimal);
            return true;
        } else {
            return false;
        }

    }
}
