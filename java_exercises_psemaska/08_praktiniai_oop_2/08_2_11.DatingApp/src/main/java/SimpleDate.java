
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                 this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance(){
        if(this.day < 30){
            this.day++;
        } else {
            this.day = 1;
            if(month < 12){
                month++;
            } else {
                month = 1;
                year++;
            }
        }
    }

    public void advance(int howManyDays){
        if((this.day + howManyDays) <= 30){
            this.day += howManyDays;
        } else {
            this.day = (this.day + howManyDays) - 30;
            if(month < 12){
                month++;
            } else {
                month = 1;
                year++;
            }
        }
    }

    public SimpleDate afterNumberOfDays(int days){

        int day = this.day;
        int month = this.month;
        int year = this.year;

        if((day + days) <= 30){
            day += days;
        } else {
            day = (day + days) - 30;
            if(month < 12){
                month++;
            } else {
                month = 1;
                year++;
            }
        }

        SimpleDate simpleDate = new SimpleDate(day, month, year);

        return simpleDate;
    }

}
