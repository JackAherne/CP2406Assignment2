/**
 * Created by Jack on 4/09/2016.
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class STGame {
    public int numberOfPlayers;
    public static int dealerID;
    public static Deck deck;
    public static CardDescription card;

    public STGame(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        this.deck = new Deck();
    }

    //Chooses which player will be the dealer from a random number in the range of players
    public int selectDealer(int numberOfPlayers) {

        Random generator = new Random();
        dealerID = generator.nextInt(numberOfPlayers);
        return dealerID;
    }

    public void dealCards(int numberOfPlayers){
        //Creates the player and bot objects
        Player.human = new Player();
        AIPlayer.bots = new AIPlayer[numberOfPlayers];
        ArrayList<CardDescription> hand;

        //Gives the player and bots a hand
        hand = deck.returnHand();
        Player.human.setHand(hand);
        for (int i = 0; i < numberOfPlayers; i++){
            AIPlayer.bots[i] = new AIPlayer();
            hand = deck.returnHand();
            AIPlayer.bots[i].setHand(hand);
        }
    }
    //Functions that are used to get the turns from the player and bots
    public void playerFirstTurn() {
        Player.human.playerFirstTurnPlayCard();
    }

    public void botFirstTurn(int firstPlayer) {
        AIPlayer.bots[firstPlayer].botFirstTurnPlayCard(firstPlayer);
    }

    public void playerTurn(){

        Player.human.playerPlayCard();
    }

    public void botTurn(int i) {
        AIPlayer.bots[i].botPlayCard(i);
    }

    //Checks if either a hand or the deck is empty, used to exit the games while loop
    public boolean isGameOver(boolean gameOver) {
        if (Player.human.hand.size() == 0) {
            System.out.println("Congratulations, you won!");
            gameOver = true;
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            if (AIPlayer.bots[i].hand.size() == 0) {
                System.out.println("Bot " + i + " wins.");
                gameOver = true;
            } else if (deck.isDeckEmpty()) {
                System.out.println("Deck is empty, nobody wins.");
                gameOver = true;
            }
        }
        return gameOver;
    }
}