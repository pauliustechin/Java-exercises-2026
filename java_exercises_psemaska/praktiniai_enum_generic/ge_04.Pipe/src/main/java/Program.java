
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here

        Pipe<String> pipe = new Pipe<>();

        pipe.putIntoThePipe("aaa");
        pipe.putIntoThePipe("ggg");
        pipe.putIntoThePipe("ddd");
        pipe.putIntoThePipe("ccc");

        while(pipe.isInPipe()) {
            System.out.println(pipe.takeFromPipe());
        }

        System.out.println(pipe.isInPipe());

        System.out.println(pipe.takeFromPipe());
    }
}
