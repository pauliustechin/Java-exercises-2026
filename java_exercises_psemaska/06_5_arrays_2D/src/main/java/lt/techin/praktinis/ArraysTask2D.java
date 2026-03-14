package lt.techin.praktinis;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysTask2D {

    public static void main(String[] args){

        int[][] arr2D = {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        int[][] arrLatin1 = {{1, 2, 3}, {2, 3, 4}, {3, 4, 1}};
        int[][] arrLatin2= {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        int[][] arr2DD = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int max = max(arr2D);
        System.out.println("Max: " + max);
        int rowSum = rowSum(arr2D, 2);
        System.out.println("RowSum: " + rowSum);
        int colSum = columnSum(arr2D, 1);
        System.out.println("ColSum: " + colSum);
        int[] rowSumArr = allRowSums(arr2D);
        System.out.println("All rows sum: " + Arrays.toString(rowSumArr));
        System.out.println("Is row magic: " + isRowMagic(arr2D));
        System.out.println("Is column magic: " + isColumnMagic(arr2D));
        System.out.println("Is square: " + isSquare(arr2D));
        System.out.println("My 2d array: " + Arrays.deepToString(arr2D));
        System.out.println("Is Magic: " + isMagic(arr2D));
        System.out.println("Is Latin: " + isLatin(arr2D));
        System.out.println("Is Latin test1: " + isLatin(arrLatin1));
        System.out.println("Is Latin test2: " + isLatin(arrLatin2));
        System.out.println("Is Sequence: " + isSequence(arr2D));
        System.out.println("Is Sequence: " + isSequence(arr2DD));
    }


    /**
     * Returns the maximum value in the 2D array arr.
     *
     * @param arr The 2D array to be processed.
     * @return The maximum value in the array.
     */
    public static int max(int[][] arr) {

        int maxNum = arr[0][0];

        for(int[] numArr : arr){
            for(int num : numArr){
                if(num > maxNum){
                    maxNum = num;
                }
            }
        }
        return maxNum;
    }

    /**
     * Returns the sum of the elements in Row x of arr.
     *
     * @param arr The 2D array to be processed.
     * @param x The row index.
     * @return The sum of elements in the specified row.
     */
    public static int rowSum(int[][] arr, int x) {

        int sum = 0;

        if(x > arr.length - 1 || x < 0){
            throw new RuntimeException("Index is out of bound");
        }

        for(int num : arr[x]){
            sum += num;
        }

        return sum;
    }

    /**
     * Returns the sum of the elements in Column x of arr.
     *
     * @param arr The 2D array to be processed.
     * @param x The column index.
     * @return The sum of elements in the specified column.
     */
    public static int columnSum(int[][] arr, int x) {

        int sum = 0;

        for(int[] numArr : arr){
            if(x > numArr.length - 1 || x < 0){
                throw new RuntimeException("Column with such index doesn't exist");
            }
            sum += numArr[x];
        }
        return sum;

    }

    /**
     * Calculates the row sum for every row in arr and returns each of the values in an array.
     *
     * @param arr The 2D array to be processed.
     * @return An array containing the sum of elements in each row.
     */
    public static int[] allRowSums(int[][] arr) {

        int[] sumArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int rowSum = 0;
            for(int num : arr[i]){
                rowSum += num;
            }
            sumArr[i] = rowSum;
        }

        return sumArr;
    }



    /**
     * Checks if the array arr is row-magic, which means that every row has the same row sum.
     *
     * @param arr The 2D array to be processed.
     * @return True if the array is row-magic, false otherwise.
     */
    public static boolean isRowMagic(int[][] arr) {

        int prevSum = rowSum(arr, 0);
        boolean isRowMagic = true;

        for(int i = 1; i < arr.length; i++){
            int rowSum = 0;
            for(int num : arr[i]){
                rowSum += num;
            }
            if(!(prevSum == rowSum)){
                isRowMagic = false;
                return isRowMagic;
            }
            prevSum = rowSum;
        }

        return isRowMagic;
    }

    /**
     * Checks if the array arr is column-magic, which means that every column has the same column sum.
     *
     * @param arr The 2D array to be processed.
     * @return True if the array is column-magic, false otherwise.
     */
    public static boolean isColumnMagic(int[][] arr) {
        int[] colSumArr = new int[arr.length];
        int prevSum = columnSum(arr, 0);
        boolean isColMagic = true;

        for(int i = 0; i < arr.length; i++) {
            int colSum = 0;
            for(int j = 0; j < arr.length; j++){
                colSum += arr[j][i];
            }
            colSumArr[i] = colSum;
            if(!(prevSum == colSum)){
                isColMagic = false;
                return isColMagic;
            }

            prevSum = colSum;
        }
        System.out.println("All columns sum: " + Arrays.toString(colSumArr));
        return isColMagic;
    }

    /**
     * Checks if the array arr is square, i.e., every row has the same length as arr itself.
     *
     * @param arr The 2D array to be processed.
     * @return True if the array is square, false otherwise.
     */
    public static boolean isSquare(int[][] arr) {
        boolean isSquare = false;

        for(int[] numArr : arr){
            if(!(numArr.length == arr.length)){
                isSquare = false;
                break;
            } else {
                isSquare = true;
            }
        }
        return isSquare;
    }

    /**
     * Checks if the array arr is a magic square, meaning it is square, and all row sums, column sums,
     * and the two diagonal-sums are equal.
     *
     * @param arr The 2D array to be processed.
     * @return True if the array is a magic square, false otherwise.
     */
    public static boolean isMagic(int[][] arr) {

        boolean isSquare = isSquare(arr);
        boolean isRowMagic = isRowMagic(arr);
        boolean isColumnMagic = isColumnMagic(arr);
        boolean isMagicSquare = false;

        if(isSquare && isRowMagic && isColumnMagic){

            int rowSum = rowSum(arr, 0);
            int colSum = columnSum(arr, 0);
            int diagonalSum1 = 0;
            int diagonalSum2 = 0;

           for(int i = 0; i < arr.length; i++){
               int[] numArr = arr[i];
               diagonalSum1 += numArr[i];
               diagonalSum2 += numArr[arr.length - i - 1];
           }

            System.out.println("Is magic square: ");
            System.out.println("Row sum: " + rowSum);
            System.out.println("Col sum: " + colSum);
            System.out.println("Diag1 sum: " + diagonalSum1);
            System.out.println("Diag2 sum: " + diagonalSum2);

           if(rowSum == colSum && colSum == diagonalSum1 && diagonalSum1 == diagonalSum2){
               isMagicSquare = true;
               return isMagicSquare;
           }
        }
        return isMagicSquare;
    }

    /**
     * Checks to see if the array arr is a Latin square, meaning it must be square, and each row and each column
     * must contain the values 1, 2, ..., n with no repeats.
     *
     * @param arr The 2D array to be processed.
     * @return True if the array is a Latin square, false otherwise.
     */
    public static boolean isLatin(int[][] arr) {

        // nepareina vienas testas su {{1, 2, 3}, {2, 3, 4}, {3, 4, 1}},
        // bet jei teisingai suprantu tai cia latin square.

        boolean isLatin = isSquare(arr);

        if(isLatin && arr.length > 1){

            for(int i = 0; i < arr.length; i++){
                int rowNum = arr[i][0];
                int colNum = arr[0][i];
                int[] tempRowArr = new int[arr.length];
                int[] tempColArr = new int[arr.length];
                tempRowArr[0] = rowNum;
                tempColArr[0] = colNum;
                for(int j = 1; j < arr.length; j++){
                    int currentRowNum = arr[i][j];
                    int currentColNum = arr[j][i];
                    if(IntStream.of(tempRowArr).anyMatch(x -> x == currentRowNum)){
                        isLatin = false;
                        return isLatin;
                    }
                    if(IntStream.of(tempColArr).anyMatch(x -> x == currentColNum)){
                        isLatin = false;
                        return isLatin;
                    }
                    tempRowArr[j] = currentRowNum;
                    tempColArr[j] = currentColNum;

                }
            }
        }
        return isLatin;
    }

    /**
     * Checks to see if the array arr is square and contains each of the digits from 1 to n*n, e.g., 1, 2, ..., 16 for a 4 x 4 array.
     *
     * @param arr The 2D array to be processed.
     * @return True if the array is a sequence, false otherwise.
     */
    public static boolean isSequence(int[][] arr) {

        boolean isSequence = isSquare(arr);

        if(isSequence){
            int prevNum = arr[0][0];
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++) {
                    if(!(i == 0 && j == 0)){
                        if(!(prevNum + 1 == arr[i][j])){
                            isSequence = false;
                            return isSequence;
                        }
                        prevNum = arr[i][j];
                    }
                }
            }
        }
        return isSequence;
    }
}
