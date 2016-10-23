import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Jack on 19/10/2016.
 */
public class BotCard extends JPanel{
    CardDescription card;
    JLabel label = new JLabel();
    ImageIcon cardImage;

    public BotCard(CardDescription card) throws IOException {
        this.card = card;
        cardImage = card.getCardBack();
        label.setIcon(cardImage);
        add(label);
    }
}