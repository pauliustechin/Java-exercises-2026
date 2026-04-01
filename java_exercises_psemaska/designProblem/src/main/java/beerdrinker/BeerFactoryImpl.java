package beerdrinker;
import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

public class BeerFactoryImpl implements BeerFactory {

    private double reserves;

    public BeerFactoryImpl() {
        this.reserves = 1;
    }

    @Override
    public void receiveMaltShippment(double v) {
        this.reserves = reserves + v;
    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {
        if(reserves <= 0) {
            throw new NoMoreMaltException("No more malt left");
        }
        reserves = reserves - 0.025;
        return new DefaultBeerBottle(0.5, 5);
    }
}
