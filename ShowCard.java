import javax.swing.*;
import java.awt.image.*;

/**
 * Created by Jack on 19/10/2016.
 */
public class ShowCard extends JPanel{
    CardDescription card;
    JLabel label = new JLabel();
    ImageIcon cardImage;

    public ShowCard(CardDescription card) {
        this.card = card;
        cardImage = card.getCardImage();
        label.setIcon(cardImage);
        add(label);

    }

}
