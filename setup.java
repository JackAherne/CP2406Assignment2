/**
 * Created by Jack on 31/08/2016.
 */
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;


public class setup {

    public static void main(String[] args) {
        int option = introductionMessage();
        if (option == 1) {
            startNewGame();
        }
        else if (option == 2) {
            System.exit(0);
        }
    }

    static void shuffleArray(cardDescriptions[] Deck)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = Deck.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            cardDescriptions a = Deck[index];
            Deck[index] = Deck[i];
            Deck[i] = a;
        }
    }

    private static int introductionMessage() {
        Scanner userMenuInput = new Scanner(System.in);
        System.out.println("Welcome to the Mineral Super Trumps game.");
        System.out.println("1. Start game");
        System.out.println("2. Exit");
        int userInput = Integer.parseInt(userMenuInput.next());
        return userInput;
    }

    private static void startNewGame() {
        int numberOfPlayers = numberOfPlayers();
        STGame game = new STGame(numberOfPlayers);
        //System.out.println(numberOfPLayers());
        game.selectDealer(numberOfPlayers);
        System.out.println("Daeler is player " + game.dealerID);


    }

    public static int numberOfPlayers() {
        System.out.println("How many players would you like to play against?");
        Scanner opponentNumber = new Scanner(System.in);
        System.out.println("Enter number between 1 and 4: ");
        int inputNumber = opponentNumber.nextInt();

        while (inputNumber < 3 || inputNumber >= 5) {
            System.out.println("Please enter number between 1 and 4: ");
            Scanner inputChecker = new Scanner(System.in);
            inputNumber = inputChecker.nextInt();
        }
        return inputNumber + 1;

    }
}
