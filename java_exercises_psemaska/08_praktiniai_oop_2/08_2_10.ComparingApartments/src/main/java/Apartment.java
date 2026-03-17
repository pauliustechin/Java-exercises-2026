
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public int getSquares() {
        return squares;
    }

    public boolean largerThan(Apartment compared){
        if(this.getSquares() > compared.getSquares()) {
            return true;
        }
        return false;
    }

    public int priceDifference(Apartment compared){

        int priceDifference = Math.abs((this.princePerSquare * this.getSquares()) - (compared.getSquares() * compared.princePerSquare));
        return priceDifference;
    }

    public boolean moreExpensiveThan(Apartment compared){

        int priceDifference = (this.princePerSquare * this.getSquares()) - (compared.getSquares() * compared.princePerSquare);
        if(priceDifference < 0){
            return false;
        }
        return true;
    }


}
