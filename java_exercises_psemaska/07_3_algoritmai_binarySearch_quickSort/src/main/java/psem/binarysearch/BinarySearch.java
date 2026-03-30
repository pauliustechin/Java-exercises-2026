package psem.binarysearch;

public class BinarySearch {

    public BinarySearch() {
    }
//                  0   1   2   3   4   5   6    7  8   9   10
//    int[] arr = {11, 14, 16, 18, 20,  25, 28, 30, 34, 40, 45};

       //           0   1   2   3   4   5   6    7  8   9   10  11  12  13  14  15  16
//    int[] arr = {11, 14, 16, 18, 20,  25, 28, 30, 34, 40, 45, 46, 47, 48, 49, 50, 51};

    public boolean binarySearch(int[] arr, int searchNumber) {
        int firstIdx = 0;
        int lastIdx = arr.length;
        return binarySearch(arr, searchNumber, firstIdx, lastIdx);

    }

    public boolean binarySearch(int[] arr, int searchNumber, int fromIdx, int toIdx) {
        int middleIdx;

        if(fromIdx == toIdx - 1) {
            if(searchNumber == arr[fromIdx]) return true;

            return false;
        } else {
            middleIdx = (fromIdx + toIdx) / 2;
            if(searchNumber == arr[middleIdx]) return true;
            else if (searchNumber < arr[middleIdx]) {
                toIdx = middleIdx;
                System.out.println("toidx" + toIdx);
            } else {
                fromIdx = middleIdx + 1;
                System.out.println("fromIdx" + fromIdx);
            }
        }

        return  binarySearch(arr, searchNumber, fromIdx, toIdx);

    }
}
