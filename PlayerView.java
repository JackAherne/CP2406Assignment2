import javax.swing.*;
import java.util.ArrayList;
import java.awt.Graphics;

/**
 * Created by Jack on 19/10/2016.
 */
public class PlayerView extends JPanel {
    Player player;


    public PlayerView(Player player) {
        this.player = player;
        addCards();
    }

    private void addCards() {

        ArrayList<CardDescription> hand = Player.human.hand;
        for (int i = 0; i < Player.human.hand.size(); i++) {
                CardDescription card = hand.get(i);
                ShowCard cardView = new ShowCard(card);
                add(cardView);
        }
    }
}
