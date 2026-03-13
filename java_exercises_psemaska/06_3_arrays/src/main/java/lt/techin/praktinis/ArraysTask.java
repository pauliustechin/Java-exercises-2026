package lt.techin.praktinis;

import java.util.Arrays;
import java.util.Random;

public class ArraysTask {


    public static void main(String[] args) {
        // Įgyvendikite visus metodus (turi pažaliuoti unit testai)
        // Pateiktas masyvas ir pavyzdys programos patikrinimui. Masyvo elementų reikšmes galite keisti.

        int[] arr = {3, 2, 1, 4, 6, 5};

        int[] arrWithRemovedElement = removeElementAndReturnNewArray(arr, 1);
        System.out.println(Arrays.toString(arrWithRemovedElement));
        int[] randomArr = generateRandomArray(10, 5, 15);
        System.out.println(Arrays.toString(randomArr));
        int[] arrWithNewElement = insertElementAndReturnNewArray(arr, 5, 8);
        System.out.println(Arrays.toString(arrWithNewElement));
        int[] reversedArr = reverseArray(arr);
        System.out.println(Arrays.toString(reversedArr));
        reverseInPlace(arr);

    }

   // Parašykite metodą, kuris sukuria nustatyto dydžio sveikųjų skaičių masyvą
   // ir užpildo jį atsitiktinai sugeneruotais skaičiais iš nurodyto intervalo.
    public static int[] generateRandomArray(int size, int min, int max) {
        //TODO
        int[] intArray = new int[size];

        Random random = new Random();

        for(int i = 0; i < size; i++){
            int randomNum = random.nextInt(min, max + 1);
            intArray[i]  =  randomNum;
        }

        return intArray;
    }


    //Parašykite metodą, kuris pašalintų masyvo arr[n] k-tąjį elementą (su indeksu k),
    //surašant reikiamus elementus į naują masyvą b[n-1]. Metodas grąžina naują masyvą.
    //Jei k yra už masyvo ribų, metodas grąžina null (teisingiau būtų mesti exception, bet dar nesimokėm)
    public static int[] removeElementAndReturnNewArray(int[] arr, int k) {
        //TODO
        if(k >= arr.length || k < 0){
            return null;
        } else {
            int[] newArr = new int[arr.length - 1];

            for(int i = 0; i < arr.length-1; i++){
                if(i >= k){
                    newArr[i] = arr[i+1];
                } else {
                    newArr[i] = arr[i];
                }
            }
            return newArr;
        }
    }

    //Parašykite metodą, kuris įterptų į masyvą arr[n] prieš k-tąjį elementą reikšmę x,
    //surašant reikiamus elementus į naują masyvą b[n+1]. Metodas grąžina naują masyvą.
    //Jei k yra už masyvo ribų, metodas grąžina null (teisingiau būtų mesti exception, bet dar nesimokėm)
    public static int[] insertElementAndReturnNewArray(int[] arr, int k, int x){
        //TODO
        if(k >= arr.length){
            return null;
        } else {
            int[] newArr = new int[arr.length + 1];

            for(int i = 0; i <= arr.length; i++){
                if(i == k){
                    newArr[i] = x;
                } else if(i > k){
                    newArr[i] = arr[i-1];
                }
                else {
                    newArr[i] = arr[i];
                }
            }
            return newArr;
        }
    }

    //Parašykite metodą, kuris grąžintų duoto masyvo apverstą kopija.
    public static int[] reverseArray(int[] arr) {
        //TODO
        int[] reverseArray = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            reverseArray[arr.length-i-1] = arr[i];
        }
        return reverseArray;
    }

    //Parašykite metodą, kuris apverstu duotą masyvą (nekuriant naujo masyvo)
    public static void reverseInPlace(int[] arr) {
        //TODO

        int times = arr.length / 2;

        for(int i = 0; i < times; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length- 1 - i];
            arr[arr.length- 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));

    }











}
