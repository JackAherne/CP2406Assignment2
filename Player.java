/**
 * Created by Jack on 7/09/2016.
 */
import java.util.ArrayList;
public class Player {
//    public ArrayList<Player> players;
    private ArrayList<CardDescription> playerHand;

    public void setPlayerHand(ArrayList<CardDescription> playerHand) {
        this.playerHand = playerHand;
    }


    public ArrayList<CardDescription> getPlayerHand() {
        return playerHand;
    }
}
