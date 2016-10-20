/**
 * Created by Jack on 31/08/2016.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Setup {

    public static void main(String[] args) throws IOException {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI.createAndShowGUI();
            }
        });
        //Begins the game
        int option = introductionMessage();

        if (option == 1) {
            startNewGame();
        }
        else if (option == 2) {
            System.exit(0);
        }

    }

    private static int introductionMessage() {
        //Welcomes user to the game
        Scanner userMenuInput = new Scanner(System.in);
        System.out.println("Welcome to the Mineral Super Trumps game.");
        System.out.println("1. Start game");
        System.out.println("2. Exit");
        int userInput = Integer.parseInt(userMenuInput.next());
        return userInput;
    }

    private static void startNewGame() throws IOException {
        boolean gameOver = false;
        Random rand = new Random();
        int number = rand.nextInt(1);
        int numberOfPlayers = getNumberOfPlayers();
        STGame game = new STGame(numberOfPlayers);
        int dealerID = game.selectDealer(numberOfPlayers);
        int i;

        //Determines first player
        int firstPlayer = dealerID - 1;
        if (dealerID - 1 == -1) {
            firstPlayer = numberOfPlayers;
        }
        System.out.println("Dealer is player " + firstPlayer + "\n");
        game.dealCards(numberOfPlayers);
        if (number == 0) {
            game.playerFirstTurn();
        }
        else {
            game.botFirstTurn(0);
        }
        //Game loop so that the game plays until exit condition is met
        while (!gameOver) {
            for (i = 0; i < game.numberOfPlayers; i++) {
                game.botTurn(i);
                gameOver = game.isGameOver(gameOver);
            }
            game.playerTurn();
            gameOver = game.isGameOver(gameOver);
        }
    }

    public static int getNumberOfPlayers() {
        //Asks the player for the number of bots to play against and makes sure their input is valid
        System.out.println("How many players would you like to play against?");
        Scanner opponentNumber = new Scanner(System.in);
        System.out.println("Enter number between 2 and 4: ");
        int inputNumber = opponentNumber.nextInt();

        while (inputNumber < 2 || inputNumber >= 5) {
            System.out.println("Please enter number between 2 and 4: ");
            Scanner inputChecker = new Scanner(System.in);
            inputNumber = inputChecker.nextInt();
        }
        return inputNumber;
    }
}
