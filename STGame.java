/**
 * Created by Jack on 4/09/2016.
 */
import java.util.Random;
import java.util.ArrayList;
public class STGame {
    public int numberOfPlayers;
    public int dealerID;

    public STGame(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
    }

    public int selectDealer(int numberOfPlayers) {
        int min = 1;
        Random generator = new Random();
        dealerID = generator.nextInt(numberOfPlayers - min + 1);
        return dealerID;
    }
}
