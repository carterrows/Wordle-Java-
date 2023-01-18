package wordle;
import java.util.Scanner;

/**
 *
 * @author Carter Rows
 */

public class Wordle {
    
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter key word:");
        String key = scan.nextLine().toUpperCase();
        
        if(key.length() != 5) {
            System.out.println("Word is not 5 letters long.");
            return;
        }
        
        String guess;
        int i = 1;
        while(i <= 6) {
            
            System.out.println("\nEnter guess #" +i);
            guess = scan.nextLine().toUpperCase();
            
            if(guess.equals(key)) {
                System.out.println(ANSI_GREEN_BACKGROUND + guess + ANSI_RESET);
                System.out.println("\nGuess is correct! The word was '" +key+"'");
                return;
            }
            
            if(guess.length() == 5) {
                
                for(int j = 0; j < 5; j++) {
                    
                    if(guess.charAt(j) == key.charAt(j)) {
                        System.out.print(ANSI_GREEN_BACKGROUND + guess.charAt(j) + ANSI_RESET);
                    }
                    else if(key.indexOf(guess.charAt(j)) != -1) {
                        System.out.print(ANSI_YELLOW_BACKGROUND + guess.charAt(j) + ANSI_RESET);
                    }
                    else {
                        System.out.print(guess.charAt(j));
                    }
                }
                System.out.println("");
                i++;
            }
            else if(guess.length() != 5) {
                System.out.println("'"+guess+"' is not 5 letters long");
            }
        }
        System.out.println("\nYou have lost.. the word was '" +key+"'");
    }
}
