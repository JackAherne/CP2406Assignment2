/**
 * Created by Jack on 4/09/2016.
 */
import java.util.Random;
import java.util.ArrayList;

public class STGame {
    public int numberOfPlayers;
    public int dealerID;
    public Deck deck;
    public Player[] players;

    public STGame(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        this.deck = new Deck();
        System.out.println(deck);
    }

    public int selectDealer(int numberOfPlayers) {
        int min = 1;
        Random generator = new Random();
        dealerID = generator.nextInt(numberOfPlayers - min + 1) + min;
        return dealerID;
    }

    public void dealCards(int numberOfPlayers){
        players = new Player[numberOfPlayers];
        ArrayList<CardDescription> playerHand;

        for (int i = 0; i < numberOfPlayers; i++){
            Player player = new Player();
            players[i] = player;
            playerHand = deck.returnHand();
            player.setPlayerHand(playerHand);
            System.out.println("player[" + i + "]=" + playerHand);
        }
    }

/**    public void showAllCards() {
        ArrayList<CardDescription> playerHand;
        for (Player player : players){
            playerHand = player.getPlayerHand();
            System.out.println(playerHand);
        }
    }*/
}
