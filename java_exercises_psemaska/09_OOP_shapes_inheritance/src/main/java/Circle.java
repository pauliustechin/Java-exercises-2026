public class Circle extends Shape{

    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(boolean filled, String color, double radius) {
        super(filled, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI * (radius * radius);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    @Override
    public String toString() {

        String parentClass = this.getClass().getSuperclass().getName();
        // Cia gal siek tiek idomiau tiesiog superClass name parasyt.
//        return ("Circle with radius=" + radius + " which is subclass of " + super.toString());
        return ("Circle with radius=" + radius + " which is subclass of " + parentClass);
    }
}
