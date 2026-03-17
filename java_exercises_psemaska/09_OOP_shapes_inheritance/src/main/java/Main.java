import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();
//
//        Shape shape = new Shape();
//        shapes.add(shape);
//        System.out.println(shape);

        Circle circle = new Circle(5);
        shapes.add(circle);
        System.out.println(circle);

        Shape rectangle = new Rectangle(4, 10);
        shapes.add(rectangle);
        System.out.println(rectangle);

        Square square = new Square(5);
        shapes.add(square);
        System.out.println(square);

        Triangle triangle = new Triangle();
        shapes.add(triangle);
        System.out.println(triangle);

        double areaSum = 0;
        double maxPerimeter = 0;
        String maxPerimeterShape = "";

        for(Shape shape2 : shapes) {
            System.out.println(shape2.getClass().getName() + " area: " + shape2.getArea());
            areaSum += shape2.getArea();
            if(maxPerimeter < shape2.getPerimeter()){
                maxPerimeter = shape2.getPerimeter();
                maxPerimeterShape = shape2.getClass().getName();
            }
            if(shape2 instanceof Square){
                System.out.println("Square side: " + ((Square) shape2).getSide());
            }
        }

        System.out.println("Area sum: " + areaSum);
        System.out.println("Shape=" + maxPerimeterShape + " has the biggest perimeter, which is: " + maxPerimeter);







    }
}
