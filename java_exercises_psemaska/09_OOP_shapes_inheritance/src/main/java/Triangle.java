public class Triangle extends Shape{

    // lygiasonis

    double side;

    public Triangle() {
        this.side = 1.0;
    }

    public Triangle(boolean filled, String color, double side) {
        super(filled, color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea(){
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }

    @Override
    public double getPerimeter(){
        return side * 3;
    }

    @Override
    public String toString() {
        String parentClass = this.getClass().getSuperclass().getName();
        return ("Equilateral triangle with side=" + side + " which is subclass of " + parentClass);
    }
}
