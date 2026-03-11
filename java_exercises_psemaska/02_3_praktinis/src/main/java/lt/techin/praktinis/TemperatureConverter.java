package lt.techin.praktinis;

public class TemperatureConverter {
    public void toFahrenheit(int temperatureCelsius){

        double fahrenheit = (temperatureCelsius * (9.0/5)) + 32;
        System.out.println(fahrenheit);
    }
}
