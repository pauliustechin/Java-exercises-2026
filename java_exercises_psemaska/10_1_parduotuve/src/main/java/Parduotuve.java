abstract public class Parduotuve {

    private String name;
    private double priceNeto;

    public Parduotuve(String name, double priceNeto) {
        this.name = name;
        this.priceNeto = priceNeto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceNeto() {
        return priceNeto;
    }

    public void setPriceNeto(double priceNeto) {
        this.priceNeto = priceNeto;
    }

    abstract public double getPriceInEuro();
    abstract public double getPriceInFranks();

    @Override
    public String toString() {
        return "Parduotuve{" +
                "name='" + name + '\'' +
                ", priceNeto=" + priceNeto +
                ", priceInEuro: " + getPriceInEuro() + "euro" +
                ", priceInFranks: " + getPriceInFranks() + "franks";
    }
}
