public class Vynas extends Parduotuve{

    private double pvm;
    private double alkTuris;
    private double kiekis;

    public Vynas(String name, double priceNeto, double kiekis, double alkTuris) {
        super(name, priceNeto);
        this.alkTuris = alkTuris;
        this.kiekis = kiekis;
        this.pvm = 0.21;
    }

    @Override
    public double getPriceInEuro() {
        if(alkTuris < 8.5){
            return ((1 + pvm) * getPriceNeto()) + ((kiekis * alkTuris / 100) * 0.28);
        } else {
            return ((1 + pvm) * getPriceNeto()) + ((kiekis * alkTuris / 100) * 0.72);
        }
    }

    @Override
    public double getPriceInFranks() {
        return getPriceInEuro() * 0.91;
    }
}
