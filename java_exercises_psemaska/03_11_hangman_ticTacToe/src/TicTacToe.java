import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    // Gal ir buvo galima kazkaip paprasciau))
    // Buriau nemazai cia.

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        while(play){

            List<String> player1Picks = new ArrayList<>();
            List<String> player2Picks = new ArrayList<>();
            List<String> allPicks = new ArrayList<>();
            boolean win = false;
            int count = 0;

            while(!win){

                System.out.println("Player 1 -> Enter row number:");
                String player1row = scanner.nextLine();

                System.out.println("Player 1 -> Enter column number:");
                String player1col = scanner.nextLine();

                String player1Pick = player1row + player1col;
                player1Picks.add(player1Pick);
                allPicks.add(player1Pick);
                count++;

                printTable(allPicks);
                win = checkIfWin(player1Picks);
                if(win){
                    System.out.println("Player 1 wins!");
                    break;
                }

                if(count == 9){
                    System.out.println("It's a tie!");
                    break;
                }


                System.out.println("Player 2 -> Enter row number:");
                String player2row = scanner.nextLine();

                System.out.println("Player 2 -> Enter column number:");
                String player2col = scanner.nextLine();

                String player2Pick = player2row + player2col;
                player2Picks.add(player2Pick);
                allPicks.add(player2Pick);
                count++;

                printTable(allPicks);
                win = checkIfWin(player2Picks);

                if(win){
                    System.out.println("Player 2 wins!");
                    break;
                }

            }

            System.out.println("Would you like to play one more time? (y/n)");
            String answer = scanner.nextLine();
            if(!(answer.equals("y"))){
                play = false;
            }

        }

    }

    public static boolean checkIfWin(List<String> playerPicks){

        ArrayList<String[]> winList = new ArrayList<>();

        String[] possibilityOne = {"11", "12", "13"};
        winList.add(possibilityOne);
        String[] possibilityTwo = {"21", "22", "23"};
        winList.add(possibilityTwo);
        String[] possibilityThree = {"31", "32", "33"};
        winList.add(possibilityThree);
        String[] possibilityFour = {"11", "21", "31"};
        winList.add(possibilityFour);
        String[] possibilityFive = {"12", "22", "32"};
        winList.add(possibilityFive);
        String[] possibilitySix = {"13", "23", "33"};
        winList.add(possibilitySix);
        String[] possibilitySeven = {"11", "22", "33"};
        winList.add(possibilitySeven);
        String[] possibilityEight = {"13", "22", "31"};
        winList.add(possibilityEight);

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

    public static void printTable(List<String> allPicks){

        String row11 = " ";
        String row12 = " ";
        String row13 = " ";
        String row21 = " ";
        String row22 = " ";
        String row23 = " ";
        String row31 = " ";
        String row32 = " ";
        String row33 = " ";

        String playerChar = "";

        for(String pick : allPicks){

            if(allPicks.indexOf(pick) % 2 == 0){
                playerChar = "X";
            } else {
                playerChar = "0";
            }

            switch (pick){
                case "11":
                    row11 = playerChar;
                    break;
                case "12":
                    row12 = playerChar;
                    break;
                case "13":
                    row13 = playerChar;
                    break;
                case "21":
                    row21 = playerChar;
                    break;
                case "22":
                    row22 = playerChar;
                    break;
                case "23":
                    row23 = playerChar;
                    break;
                case "31":
                    row31 = playerChar;
                    break;
                case "32":
                    row32 = playerChar;
                    break;
                case "33":
                    row33 = playerChar;
                    break;
                default:
                    System.out.println("Wrong value.");
            }
        }


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
