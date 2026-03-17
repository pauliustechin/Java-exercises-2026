public abstract class Shape {

    private String color = "red";
    private boolean filled = true;

    public Shape() {

    }

    public Shape(boolean filled, String color) {
        this.filled = filled;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract public double getArea();

    abstract public double getPerimeter();

    @Override
    public String toString() {

        String filledAnswer = "";
        if(filled){
            filledAnswer = "filled";
        } else {
            filledAnswer = "Not filled";
        }


        return ("A Shape with color of " + color + " and " + filledAnswer);
    }
}
