
public class Statistics {

    private int count;
    private int sum = 0;

    public Statistics() {
        this.count = 0;
    }

    public void addNumber(int number) {
        sum += number;
        count++;
    }

    public int getCount() {
        return count;
    }

    public int sum() {
        return sum;
    }

    public double average() {
        if(count > 0){
            double average = (double) sum / count;
            return average;
        }
        return 0.0;

    }


}

