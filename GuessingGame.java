import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();

        System.out.println("      =========================================");
        System.out.print("      ");
        System.out.println(RED_BACKGROUND+"            GUESSING GAME 🎮             "+RESET);
        System.out.println("      =========================================");

        System.out.println();

        System.out.println(GREEN +"Select The Level Of Game Form : 1-50 for easy, 1-100 for medium, and 1-500 for hard");
        System.out.println("    1.easy (Range : [1-50])");
        System.out.println("    2.Medium (Range : [1-100])");
        System.out.println("    3.Hard (Range : [1-500])");
        System.out.println();
        int level = 0;
        while (level < 1 || level > 3) {
            System.out.print("    >>level : " + RESET);
            level = sc.nextInt();
            if (level < 1 || level > 3) {
                System.out.println(RED + "    Invalid level! Please choose 1, 2, or 3." + RESET);
            }
        }
        int range = (level==3)?500:level*50;

        System.out.println();

        System.out.printf(YELLOW + "    I have picked a random number between 1 and %d ." , range);

        System.out.println("\n");

        System.out.println("       Your mission is to guess the number! 😎" +RESET);

        System.out.println();

        int numberToGuess = rand.nextInt(range) + 1;
        int attempts = 0;

        while(true){
            System.out.print(CYAN + "Enter your guess: " + RESET);
            int guess = sc.nextInt();

            System.out.println();

            attempts++;

            if(guess < numberToGuess){
                System.out.println("    🔥 Too low! Aim higher! 🔝 \n");
            }
            else if(guess > numberToGuess){
                System.out.println("    ❄️ Too high! Aim lower! 🔻 \n");
            }
            else{
                break;
            }
        }

        System.out.println("      =========================================");
        System.out.println(YELLOW+"            🎉 CONGRATULATIONS! YOU WIN! 🎉     "+RESET);
        System.out.println("      ========================================= \n");

        System.out.println(BRIGHT_CYAN+"      The number was: " + numberToGuess );
        System.out.println();
        System.out.printf("      It took you %d attempts to win the game." , attempts );
        System.out.println("\n"+RESET);
        System.out.println("      =======================================");
        System.out.print("      ");
        System.out.println(RED_BACKGROUND+"     Thanks for playing the game!      "+RESET);
        System.out.println("      =======================================");
        System.out.println();
        System.out.print(GREEN + "      Would you like to play again? (yes/no): " + RESET);
        String playAgain = sc.next().toLowerCase();
        System.out.println();
        if (playAgain.equals("yes")) {
            main(args); 
        } else {
            System.out.print("      ");
            System.out.println(RED_BACKGROUND + "     Thanks for playing the game!      " + RESET);
        }

    }
}