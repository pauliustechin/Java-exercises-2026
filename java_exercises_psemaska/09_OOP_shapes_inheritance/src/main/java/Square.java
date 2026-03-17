public class Square extends Rectangle{

    public Square() {
    }

    public Square(boolean filled, String color, double side) {
        super(filled, color);
    }

    public double getSide() {
        return getLength() * getWidth();
    }

    @Override
    public double getArea() {
        double side = getLength() * getWidth();
        return side * side;
    }

    @Override
    public double getPerimeter() {
        double side = getLength() * getWidth();
        return side * 4;
    }

    @Override
    public String toString() {
        double side = getLength() * getWidth();
        String parentClass = this.getClass().getSuperclass().getName();
        return ("Square with side=" + side + " which is subclass of " + parentClass);
    }
}
