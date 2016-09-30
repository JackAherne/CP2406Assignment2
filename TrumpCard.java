/**
 * Created by Jack on 31/08/2016.
 */
public class TrumpCard extends CardDescription {
    public TrumpCard(String name, String economicValue){
        super(name, economicValue);
    }

    //Defines how to print the cards
    public String toString() {
        return "Card Name: " + cardTitle + "  " + "Category: " + cardEconomicValue + "\n" ;
    }
}
