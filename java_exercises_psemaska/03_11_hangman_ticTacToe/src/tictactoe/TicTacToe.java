package tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    String player1;
    String player2;

    public TicTacToe(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(){

        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        // cia vistiek toks griozdelis gaunas

        while(play){

            List<String> player1Picks = new ArrayList<>();
            List<String> player2Picks = new ArrayList<>();
            List<Integer> allRows = new ArrayList<>();
            List<Integer> allCols = new ArrayList<>();
            boolean win = false;
            int count = 0;

            while(!win){
                getPlayerInput(player1, player1Picks, allRows, allCols);
                printTable(allRows, allCols);
                count++;
                win = checkIfWin(player1Picks);
                if(win){
                    System.out.println(player1 + " wins!");
                    break;
                }

                if(count == 9){
                    System.out.println("It's a tie!");
                    break;
                }

                getPlayerInput(player2, player2Picks, allRows, allCols);
                printTable(allRows, allCols);
                count++;
                win = checkIfWin(player2Picks);
                if(win){
                    System.out.println(player2 + " wins!");
                    break;
                }
            }

            System.out.println("Would you like to play one more time? (y/n)");
            String answer = scanner.nextLine();
            if(!(answer.equals("y"))){
                play = false;
                scanner.close();
            }
        }
    }

    private static void getPlayerInput(String name,
                                       List<String> playerPicks,
                                       List<Integer> rows,
                                       List<Integer> cols){
        Scanner scanner = new Scanner(System.in);

        System.out.println(name + " -> Enter row number:");
        String row = scanner.nextLine();

        System.out.println(name + " -> Enter column number:");
        String col = scanner.nextLine();

        String playerPick = row + col;
        playerPicks.add(playerPick);
        rows.add(Integer.parseInt(row) - 1);
        cols.add(Integer.parseInt(col) - 1);
    }

    private static boolean checkIfWin(List<String> playerPicks){

        String[][] winList = {{"11", "12", "13"}, {"21", "22", "23"}, {"31", "32", "33"},
                {"11", "21", "31"}, {"12", "22", "32"}, {"13", "23", "33"},
                {"11", "22", "33"}, {"13", "22", "31"}};


        boolean win = false;

        for(String[] winPos : winList){

            win = true;

            for(String pos: winPos){
                if(!(playerPicks.contains(pos))){
                    win = false;
                    break;
                }
            }
            // jei nors viena possibility isejo su true darom break,
            // kad kitu nebetikrintu.
            if(win){
                break;
            }
        }

        return win;
    }

    private static void printTable(List<Integer> rows, List<Integer> cols){

        String[][] table = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

        for(int i = 0; i < rows.size(); i++){
            int row = rows.get(i);
            int col = cols.get(i);
            if(i % 2 == 0){
                table[row][col] = "X";
            } else {
                table[row][col] = "O";
            }
        }

        for(String[] arr: table){
            System.out.println("-------------");
            System.out.print("| ");
            for(String val: arr){
                System.out.print(val + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }


}
