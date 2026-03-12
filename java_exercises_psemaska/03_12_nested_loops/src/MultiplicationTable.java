public class MultiplicationTable {
    public static void main(String[] args){
        // x = kokio dydzio lenta
        printMultiplicatonTable(5);
    }

    public static void printMultiplicatonTable(int x){

        int[] nums = new int[x];

        for(int i = 0; i < x; i++){
            nums[i] = i+1;
        }
        printHeader(nums, x);
        printTable(nums, x);
    }

    public static void printHeader(int[] nums, int x) {
        System.out.print("    ");
        for (int num : nums) {
            System.out.print(num + "  ");
            if (num == x) {
                System.out.println();
                System.out.println("------------------------------");
            }
        }
    }

    public static void printTable(int[] nums, int x){
        for(int num : nums){
            System.out.print(num + " | ");
            for(int num2 : nums){
                if(num * num2 < 10){
                    System.out.print(num2 * num + "  ");
                } else {
                    System.out.print(num2 * num + " ");
                }

                if(num2 == x){
                    System.out.println();
                }
            }
        }
    }

}
