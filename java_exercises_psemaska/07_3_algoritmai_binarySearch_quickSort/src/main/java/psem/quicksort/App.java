package psem.quicksort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] arr = {20, 11, 18, 14, 26, 9, 32, 5, 15, 27, 55, 62, 80, 11, 3, 88, 57};

        QuickSort quickSort = new QuickSort();

        System.out.println(Arrays.toString(arr));
        quickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
