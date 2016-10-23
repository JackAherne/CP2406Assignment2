import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jack on 22/10/2016.
 */
public class BotView extends JPanel{

        AIPlayer player;


        public BotView(AIPlayer player) throws IOException {
            this.player = player;

            addCards();
        }

        private void addCards() throws IOException {

            ArrayList<CardDescription> hand = player.getHand();

            for (int i = 0; i < hand.size(); i++) {
                    CardDescription card = hand.get(i);
                    BotCard botView = new BotCard(card);
                    add(botView);
                }
            }
        }


