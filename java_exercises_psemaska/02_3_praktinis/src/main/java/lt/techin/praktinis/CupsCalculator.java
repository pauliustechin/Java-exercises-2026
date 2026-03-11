package lt.techin.praktinis;

public class CupsCalculator {

    public void calculateCups(int numberOfCups) {

        int deziu = numberOfCups / 3;
        int puodeliu = numberOfCups % 3;

        System.out.println("Dėžių: " + deziu);
        System.out.println("Liko puodelių: " + puodeliu);
    }

}
