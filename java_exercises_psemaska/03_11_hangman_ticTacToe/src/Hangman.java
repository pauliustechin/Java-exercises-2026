import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        while(play){

            String[] words = {"test", "learning"};
            Random random = new Random();
            int randomNum = random.nextInt(0, words.length);

            int wordLength = words[randomNum].length();
            String word = words[randomNum];
            StringBuilder hiddenWord = new StringBuilder("*".repeat(wordLength));
            int guessCount = 0;

            while(hiddenWord.indexOf("*") != -1){

                System.out.print("Enter a letter in word " + hiddenWord + " > ");
                char guess = scanner.nextLine().charAt(0);

                if(hiddenWord.indexOf(String.valueOf(guess)) == 0){
                    System.out.println(guess + " is already in a word");
                } else {
                    boolean found = checkGuess(wordLength, word, hiddenWord, guess);
                    if(!found){
                        System.out.println(guess + " is not in the word");
                        guessCount++;
                    }
                }
            }

            System.out.println("The word is " + hiddenWord + ". You missed " + guessCount + " times." );
            System.out.println("Do you want to guess another word? (y/n)");
            String answer = scanner.nextLine();
            if(!answer.equals("y")){
                play = false;
            }

        }

    }

    public static boolean checkGuess(int wordLength, String word, StringBuilder hiddenWord, char guess){
        boolean found = false;
        for(int i = 0; i < wordLength; i++){
            if(word.charAt(i) == guess){
                hiddenWord.setCharAt(i, guess);
                found = true;
            }
        }
        return found;
    }
}
