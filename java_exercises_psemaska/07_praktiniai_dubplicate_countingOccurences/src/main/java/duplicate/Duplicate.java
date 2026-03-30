package duplicate;

public class Duplicate {

    public static void main(String[] args) {

        //           0  1  2  3  4  5
        int arr[] = {2, 1, 3, 5, 13, 12, 6, 9, 11, 5, 7};

        System.out.println(fastestDuplicate(arr));
    }

    public static int fastestDuplicate(int[] arr) {
        int dublicateIndex = -1;
        // smallest index prilyginam paskutiniam arr skaiciui, kad butu galima eit i mazejimo puse.
        int smallestIndex = (arr.length - 1);

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    dublicateIndex = j;
                    // jei pries tai rasto dublikato indexas didesnis, nei tikrinamo,
                    // tada priskiriam nauja dublikato indexa.
                    if(dublicateIndex < smallestIndex) {
                        smallestIndex = dublicateIndex;
                    }
                    // break, kad daugiau nebetikrintu kai randamas dublikatas.
                    break;
                }
            }

            // jei i is pirmo for loop >= nei smallestIndex, galima uzbaigt programa,
            // nes dublikato su mazesniu indexu jau nebus.
            if(i >= smallestIndex && dublicateIndex != -1){
                System.out.println("Duplicate with the smallest index: " + arr[smallestIndex] + ", index: " + smallestIndex);
                return arr[smallestIndex];
            }
        }

        System.out.println("No duplicates were found!");
        return -1;
    }



}
