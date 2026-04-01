package beerdrinker;

import itadesign.beerdrinker.BeerBottle;

import java.util.Objects;

public class DefaultBeerBottle implements BeerBottle {

    private double volumeInLiters;
    private double alcoholContentInPercent;

    public DefaultBeerBottle(double volumeInLiters, double alcoholContentInPercent) {
        this.volumeInLiters = volumeInLiters;
        this.alcoholContentInPercent = alcoholContentInPercent;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return alcoholContentInPercent;
    }

    public void setAlcoholContentInPercent(double alcoholContentInPercent) {
        this.alcoholContentInPercent = alcoholContentInPercent;
    }

    @Override
    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    @Override
    public void takeASip(double v) {
        volumeInLiters = volumeInLiters - v;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DefaultBeerBottle that = (DefaultBeerBottle) o;
        return Double.compare(volumeInLiters, that.volumeInLiters) == 0 && Double.compare(alcoholContentInPercent, that.alcoholContentInPercent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumeInLiters, alcoholContentInPercent);
    }
}
