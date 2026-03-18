package saskaita;

abstract class Bank {

    private final int accountNumer;
    private final String name;

    public Bank(int accountNumer, String name) {
        this.accountNumer = accountNumer;
        this.name = name;
    }

    public int getAccountNumer() {
        return accountNumer;
    }

    public String getName() {
        return name;
    }

    abstract void proceedOperation(Bank bank);
}
