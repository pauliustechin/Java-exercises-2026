import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyBank implements Bank {

    private List<Account> accounts = new ArrayList<>();

    public MyBank() {
    }

    @Override
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        BigDecimal totalReserves = BigDecimal.ZERO;

        for(Account account : accounts) {
            totalReserves = totalReserves.add(account.getBalance());
        }

        return totalReserves;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account openDebitAccount(String s) {

        for(Account account : accounts) {
            if(account.getHolderName().equals(s)){
                return null;
            }
        }
        Account account = new AccountImpl(s);
        accounts.add(account);
        return account;
    }

    @Override
    public Account openCreditAccount(String s, BigDecimal bigDecimal) {
        for(Account account : accounts) {
            if(account.getHolderName().equals(s)){
                return null;
            }
        }
        Account account = new AccountImpl(s, bigDecimal);
        accounts.add(account);
        return account;
    }

    @Override
    public Account getAccountByHolderName(String s) {
        return accounts.stream()
                .filter(account -> account.getHolderName().equals(s))
                .findFirst().orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {
        return accounts.stream()
                .filter(account -> account.getNumber().equals(s))
                .findFirst().orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accounts.remove(account);
    }
}
