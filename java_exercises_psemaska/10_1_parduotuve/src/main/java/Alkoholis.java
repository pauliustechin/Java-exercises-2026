public class Alkoholis extends Parduotuve{

    private double pvm;
    private double alkTuris;
    private double kiekis;

    public Alkoholis(String name, double priceNeto, double kiekis, double alkTuris) {
        super(name, priceNeto);
        this.pvm = 0.21;
        this.kiekis = kiekis;
        this.alkTuris = alkTuris;
    }

    @Override
    public double getPriceInEuro() {
        if(alkTuris < 15){
            return ((1 + pvm) * getPriceNeto()) + ((kiekis * alkTuris / 100) * 0.89);
        } else {
            return ((1 + pvm) * getPriceNeto()) + ((kiekis * alkTuris / 100) * 1.26);
        }
    }

    @Override
    public double getPriceInFranks() {
        return getPriceInEuro() * 0.91;
    }

}
