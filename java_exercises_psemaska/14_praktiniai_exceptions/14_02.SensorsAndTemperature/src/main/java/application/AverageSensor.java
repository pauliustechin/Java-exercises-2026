package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors = new ArrayList<>();
    private List<Integer> readings = new ArrayList<>();


    @Override
    public boolean isOn() {
        for(Sensor sensor : sensors) {
            if(!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for(Sensor sensor : sensors) {
            if(!sensor.isOn()) {
                sensor.setOn();
            }
        }
    }

    @Override
    public void setOff() {
        for(Sensor sensor : sensors) {
            if(sensor.isOn()) {
                sensor.setOff();
                break;
            }
        }
    }

    @Override
    public int read() {

        if(sensors.isEmpty() || !isOn()) {
            throw new IllegalStateException();
        }

        int avg  = (int) sensors.stream()
                .mapToInt(Sensor::read)
                .average().orElse(0);

        readings.add(avg);

        return avg;
    }

    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }

    public List<Integer> readings() {
        return readings;
    }

}
