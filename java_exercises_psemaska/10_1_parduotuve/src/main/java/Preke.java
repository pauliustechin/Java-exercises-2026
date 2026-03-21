public class Preke extends Parduotuve{

    private double pvm;

    public Preke(String name, double priceNeto) {
        super(name, priceNeto);
        this.pvm = 0.21;
    }

    @Override
    public double getPriceInEuro() {
        return getPriceNeto() * (1 + pvm);
    }

    @Override
    public double getPriceInFranks() {
        return getPriceInEuro() * 0.91;
    }
}
