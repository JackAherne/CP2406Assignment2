/**
 * Created by Jack on 4/09/2016.
 */
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class STGame {
    public int numberOfPlayers;
    public int dealerID;
    public Deck deck;

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
}
