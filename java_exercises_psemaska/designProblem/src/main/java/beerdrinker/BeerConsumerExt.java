package beerdrinker;

import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;

public class BeerConsumerExt extends BeerConsumer {

    public BeerConsumerExt() {
    }

    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {
        if(beerBottle.getVolumeInLiters() > 0.5
                || (beerBottle.getAlcoholContentInPercent() > 6)
                || (this.getBloodAlcoholContentInLiters() > (120 / 1000))) {
            return false;
        }
        return true;
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean b) {
        if(b) {
            beerBottle = new NonAlcoholBeerBottle(beerBottle);
            return beerBottle;
        }
        return beerBottle;
    }
}
