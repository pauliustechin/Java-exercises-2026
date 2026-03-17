
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        Money newMoney = new Money((this.euros() + addition.euros()), (this.cents() + addition.cents()));

        return newMoney;

    }

    public boolean lessThan(Money compared) {

        double thisMoney = this.euros() + (double) this.cents() / 100;
        double comparedMoney = compared.euros() + (double) compared.cents() / 100;

        if(thisMoney < comparedMoney) {
            return true;
        }

        return false;
    }

    public Money minus(Money decreaser){
        double thisMoney = this.euros() + (double) this.cents() / 100;
        double decreaserMoney = decreaser.euros() + (double) decreaser.cents() / 100;
        double difference = thisMoney - decreaserMoney;

        if(difference <= 0){
            return new Money(0,0);
        } else {
            int euros = (int) Math.floor(difference);
            double cents = Math.round(((difference-euros) % 10 * 100));
            return new Money(euros, (int) cents);
        }

    }

}
