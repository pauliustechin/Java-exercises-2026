public class TicTacToe {

    public static void main(String[] args){

        String row11 = " ";
        String row12 = " ";
        String row13 = " ";
        String row21 = " ";
        String row22 = " ";
        String row23 = " ";
        String row31 = " ";
        String row32 = " ";
        String row33 = " ";

        row21 = "X";

        printTable(row11, row12, row13, row21, row22, row23, row31, row32, row33);

    }




    public static void printTable(String row11,
                                  String row12,
                                  String row13,
                                  String row21,
                                  String row22,
                                  String row23,
                                  String row31,
                                  String row32,
                                  String row33
                                  ){
        String firstRow = ("| " + row11 + " | " + row12 + " | " + row13 + " |");
        String secondRow = ("| " + row21 + " | " + row22 + " | " + row23 + " |");
        String thirdRow = ("| " + row31 + " | " + row32 + " | " + row33 + " |");

        System.out.println("-------------");
        System.out.println(firstRow);
        System.out.println("-------------");
        System.out.println(secondRow);
        System.out.println("-------------");
        System.out.println(thirdRow);
        System.out.println("-------------");
    }


}
