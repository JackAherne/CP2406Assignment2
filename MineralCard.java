/**
 * Created by Jack on 31/08/2016.
 */
public class MineralCard extends CardDescription {

    public MineralCard(String title, String chemistry, String classification,
                       String crystalSystem, String occurrence, double hardness,
                       double specificGravity, String cleavage, String crustalAbundance,
                       String economicValue) {
        super(title, chemistry, classification, crystalSystem, occurrence, hardness, specificGravity, cleavage, crustalAbundance, economicValue);
    }


    public String toString() {
        return "Name: " + cardTitle + " " + "Chemistry: " + cardChemistry + "  " + "Classification: " + cardClassification + "  " +"Crystal System: " + cardCrystalSystem + "  " + "Occurence: " + cardOccurrence + "  " + "Hardness: " + cardHardness + "  " + "Specific Gravity: " + cardSpecificGravity + "  " + "Cleavage: " + cardCleavage + "  " + "Crustal Abundance: "+ cardCrustalAbundance + "  " + "Economic Value: " + cardEconomicValue + "\n\n";
    }
}