import java.awt.image.BufferedImage;

/**
 * Created by Jack on 31/08/2016.
 */
public class TrumpCard extends CardDescription {
    public TrumpCard(String name, String economicValue, BufferedImage cardPicture){
        super(name, economicValue, cardPicture);
    }

    //Defines how to print the cards
    public String toString() {
        return "Card Name: " + cardTitle + "  " + "Category: " + cardEconomicValue + "\n" ;
    }
}
