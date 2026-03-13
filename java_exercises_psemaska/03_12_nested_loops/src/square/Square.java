package square;

public class Square {

    int squareDimensions;

    public Square(int squareDimensions){
        this.squareDimensions = squareDimensions;
    }

    public void printSquare(){
        for(int i = 0; i < squareDimensions; i++){
            if(i == 0 || (i == (squareDimensions-1))){
                for(int j = 0; j < squareDimensions; j++){
                    System.out.print("# ");
                }
                System.out.println();
            } else {
                for(int k = 0; k < squareDimensions; k++){
                    if(k == 0 || k == squareDimensions-1){
                        System.out.print("# ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }

}
