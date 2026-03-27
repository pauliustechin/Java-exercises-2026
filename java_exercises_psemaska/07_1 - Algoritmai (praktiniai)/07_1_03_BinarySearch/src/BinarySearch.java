public class BinarySearch {
    public static boolean search(int[] array, int searchedValue) {
        int beginning = 0;
        int end = array.length - 1;

        if(searchedValue < array[0] || searchedValue > array[end]) {
            return false;
        }

        while (beginning <= end) {
            int middle = (beginning + end) / 2;
            if (array[middle] == searchedValue) {
                return true;
            } else if (searchedValue < array[middle]) {
                end = middle - 1;
            } else if (searchedValue > array[middle]){
                beginning = middle + 1;
            }
            // restrict the search area
        }
        return false;
    }
}
