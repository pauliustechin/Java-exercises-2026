import java.util.Arrays;

public class SumOfArray {

    public static void main(String[] args) {
        // You can try the method here
        int[] array = {5, 1, 3, 4, 2};
        System.out.println(sumOfNumbersInArray(array));
    }

    public static int sumOfNumbersInArray(int[] array) {
        // Write some code here
        int result = Arrays.stream(array).reduce(0, (num1,  num2) -> num1+num2);
        return result;
    }
}
