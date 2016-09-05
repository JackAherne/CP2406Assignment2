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
    public ArrayList deck;

    public STGame(int numberOfPlayers, ArrayList deck){
        this.numberOfPlayers = numberOfPlayers;
        this.deck = deck;
    }

    public int selectDealer(int numberOfPlayers) {
        int min = 1;
        Random generator = new Random();
        dealerID = generator.nextInt(numberOfPlayers - min + 1);
        return dealerID;
    }
}
