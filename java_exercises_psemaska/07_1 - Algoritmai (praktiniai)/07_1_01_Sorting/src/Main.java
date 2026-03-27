
public class Main {
    public static void main(String[] args) {
        // write testcode here

    }

    public static int smallest(int[] array) {
        int smallest = array[0];
        for(int i = 1; i < array.length; i++) {
            if(smallest > array[i]) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest (int[] array) {
        int smallest = array[0];
        int indexOfTheSmallest = 0;
        for(int i = 1; i < array.length; i++) {
            if(smallest > array[i]) {
                smallest = array[i];
                indexOfTheSmallest = i;
            }
        }
        return indexOfTheSmallest;
    }

    public static int indexOfTheSmallestStartingFrom (int[] array, int index) {
        int smallest = array[index];
        int indexOfTheSmallest = index;
        for(int i = index; i < array.length; i++) {
            if(smallest > array[i]) {
                smallest = array[i];
                indexOfTheSmallest = i;
            }
        }
        return indexOfTheSmallest;
    }

    public static void swap(int[] array, int index1, int index2) {

        int num = array[index1];
        array[index1] = array[index2];
        array[index2] = num;

    }

    public static void sort(int[] array) {
        int indexOfTheSmallestNum;
        for(int i = 0; i < array.length; i++) {
            indexOfTheSmallestNum = indexOfTheSmallestStartingFrom(array, i);
            swap(array, i, indexOfTheSmallestNum);
        }

    }








}
