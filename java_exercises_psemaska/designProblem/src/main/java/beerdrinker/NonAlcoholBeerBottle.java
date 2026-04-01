package beerdrinker;

import itadesign.beerdrinker.BeerBottle;

public class NonAlcoholBeerBottle implements BeerBottle {

    private BeerBottle beerBottle;

    public NonAlcoholBeerBottle(BeerBottle beerBottle) {
        this.beerBottle = beerBottle;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return 0.0;
    }

    @Override
    public double getVolumeInLiters() {
        return beerBottle.getVolumeInLiters();
    }

    @Override
    public void takeASip(double v) {
        beerBottle.takeASip(v);
    }
}
