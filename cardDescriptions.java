/**
 * Created by Jack on 31/08/2016.
 */
import java.util.*;
public class cardDescriptions {

    public String cardTitle;
    public String cardChemistry;
    public String cardClassification;
    public String cardCrystalSystem;
    public String cardOccurrence;
    public double cardHardness;
    public double cardSpecificGravity;
    public String cardCleavage;
    public String cardCrustalAbundance;
    public String cardEconomicValue;

    public cardDescriptions(String title, String chemistry, String classification,
                            String crystalSystem, String occurrence, double hardness,
                            double specificGravity, String cleavage, String crustalAbundance,
                            String economicValue) {
        cardTitle = title;
        cardChemistry = chemistry;
        cardClassification = classification;
        cardCrystalSystem = crystalSystem;
        cardOccurrence = occurrence;
        cardHardness = hardness;
        cardSpecificGravity = specificGravity;
        cardCleavage = cleavage;
        cardCrustalAbundance = crustalAbundance;
        cardEconomicValue = economicValue;
    }

    public cardDescriptions(String title, String economicValue) {
        cardTitle = title;
        cardEconomicValue = economicValue;
    }

    public String toString() {
        return "cardTitle= " + cardTitle + " ," + cardChemistry;
    }

}

