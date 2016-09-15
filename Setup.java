/**
 * Created by Jack on 31/08/2016.
 */

import java.util.Scanner;

public class Setup {

    public static void main(String[] args) {
        int option = introductionMessage();
        if (option == 1) {
            startNewGame();
        }
        else if (option == 2) {
            System.exit(0);
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
        game.selectDealer(numberOfPlayers);
        System.out.println("Dealer is player " + game.dealerID);
        game.dealCards(numberOfPlayers);
        game.playerFirstTurn();

    }

    public static int numberOfPlayers() {
        System.out.println("How many players would you like to play against?");
        Scanner opponentNumber = new Scanner(System.in);
        System.out.println("Enter number between 2 and 4: ");
        int inputNumber = opponentNumber.nextInt();

        while (inputNumber < 2 || inputNumber >= 5) {
            System.out.println("Please enter number between 2 and 4: ");
            Scanner inputChecker = new Scanner(System.in);
            inputNumber = inputChecker.nextInt();
        }
        return inputNumber + 1;
    }
}
