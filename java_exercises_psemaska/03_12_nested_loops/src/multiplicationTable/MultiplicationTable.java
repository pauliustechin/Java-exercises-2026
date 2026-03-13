package multiplicationTable;

public class MultiplicationTable {

    int tableSize;

    public MultiplicationTable(int tableSize){
        this.tableSize = tableSize;
    }

    public void printMultiplicatonTable(){

        int[] nums = new int[tableSize];

        for(int i = 0; i < tableSize; i++){
            nums[i] = i+1;
        }
        printHeader(nums, tableSize);
        printTable(nums, tableSize);
    }

    private static void printHeader(int[] nums, int tableSize) {
        System.out.print("    ");
        for (int num : nums) {
            System.out.print(num + "  ");
            if (num == tableSize) {
                System.out.println();
                System.out.println("------------------------------");
            }
        }
    }

    private static void printTable(int[] nums, int tableSize){
        for(int num : nums){
            System.out.print(num + " | ");
            for(int num2 : nums){
                if(num * num2 < 10){
                    System.out.print(num2 * num + "  ");
                } else {
                    System.out.print(num2 * num + " ");
                }

                if(num2 == tableSize){
                    System.out.println();
                }
            }
        }
    }

}
