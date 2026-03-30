package psem.quicksort;

public class QuickSort {

    //              0   1   2   3   4   5   6  7   8
    // int[] arr = {20, 11, 18, 14, 26, 9, 32, 5, 15};

    public QuickSort() {

    }

    public boolean quickSort(int[] arr) {

        int middleIdx = (arr.length - 1) / 2;
        int pivot = arr[middleIdx];
        arr[middleIdx] = arr[arr.length - 1];
        arr[arr.length - 1] = pivot;

        // vidurini skaiciu (pivot) pasidedam i pabaiga ir paduodam rekursijai.
        return quickSort(arr, 0, arr.length - 1);

    }

    public boolean quickSort(int[] arr, int fromIdx, int lastIdx) {

        // jei array tik is vieno skaiciaus, grazinam true;
        if(lastIdx - fromIdx < 1) {
            return true;
        }

        // cia pivot iskart paskutinis skaicius.
        int pivot = lastIdx;
        int current = fromIdx;
        int swapPos = fromIdx - 1;

        // kai tikrinamas skaicius issilygina su paskutiniu, uzdarom loop.
        while(current != lastIdx) {
            // jei tikrinamas skaicius mazesnis, nei pivot swapPos didinam vienu,
            // ir i jo vieta pasidedam current, o swapPos i current, taip gaunas, kad
            // turim paskutinio maziausio skaiciaus indeksa, o po jo eina visi >= uz pivot.
            if(arr[current] < arr[pivot]) {
                swapPos++;
                int temp = arr[swapPos];
                arr[swapPos] = arr[current];
                arr[current] = temp;
                current++;
            } else {
                current++;
            }
        }

        // kai ciklas uzsidaro, pivot sukeiciam su didesniu skaiciumi, kurio indexas vienu didesnis,
        // nei paskutinis mazesnis skaicius uz pivot.
        int temp = arr[pivot];
        arr[pivot] = arr[swapPos + 1];
        arr[swapPos + 1] = temp;

        //              0   1   2  3   4   5   6  7   8
        // int[] arr = {11, 14, 9, 5, 15, 18, 32, 20, 26};

        // pivot paliekam, o skirtingose pusese esantis skaiciai sudaro du array.
        // Viena su didesniais skaiciais uz pivot, kita su mazesniais.
        // leidziam rekursija vienai ir kitai pusei. Mazesne puse visada prasides nuo 0,
        // o didesne, swapPos + 2. Rekursija kartojasi, kol lieka tik vienas elementas ir grazinama reiksme true;
        quickSort(arr, 0, swapPos);
        quickSort(arr, swapPos + 2, lastIdx);

        return true;
    }

}
