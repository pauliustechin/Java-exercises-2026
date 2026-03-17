public class Square extends Rectangle{

    public Square() {
    }

    public Square(int side) {
        super(side, side);
    }

    public double getSide() {
        return getLength();
    }

    @Override
    public String toString() {
        double side = getLength() * getWidth();
        String parentClass = this.getClass().getSuperclass().getName();
        return ("Square with side=" + side + " which is subclass of " + parentClass);
    }
}
