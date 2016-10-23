import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jack on 19/10/2016.
 */
public class ShowCard extends JPanel{
    CardDescription card;
    JLabel label = new JLabel();
    ImageIcon cardImage;
    public GUI gui = new GUI();

    public ShowCard(CardDescription card) {
        this.card = card;
        cardImage = card.getCardImage();
        label.setIcon(cardImage);
        label.setBackground(Color.CYAN);
        add(label);


        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                STGame.currGame.playerFirstTurn(card);
                ShowCard.this.removeAll();
                repaint();
                revalidate();

                gui.addCardToDeck(card);

                for (int i = 0; i < 3; i++) {
                    CardDescription botCard = AIPlayer.bots[i].botPlayCard(i);
                    gui.addCardToDeck(botCard);
                }
            }
        });
    }
}
