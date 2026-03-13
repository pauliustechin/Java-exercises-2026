

public class FromOneToParameter {

    public static void main(String[] args) {

        printUntilNumber(5);

    }

    public static void printUntilNumber(int numbers){
        for(int i = 1; i <= numbers; i++){
            System.out.println(i);
        }
    }

}
