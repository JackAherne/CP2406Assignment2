/**
 * Created by Jack on 31/08/2016.
 */
import java.util.*;
public class CardDescription {

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

    public CardDescription(String title, String chemistry, String classification,
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

    public CardDescription(String title, String economicValue) {
        cardTitle = title;
        cardEconomicValue = economicValue;
    }

    public static boolean compareCards(String firstAttrValue, String secondAttrValue){
        boolean compare = true;
        System.out.println("Compare cards First Attribute: " + firstAttrValue + " Second Attribute: " + secondAttrValue);
        if (tryParseInt(firstAttrValue, secondAttrValue)) {
            double firstAttrValueInt = Double.parseDouble(firstAttrValue);
            double secondAttrValueInt = Double.parseDouble(secondAttrValue);
            if (firstAttrValueInt <= secondAttrValueInt) {
                compare = false;
            }
            else{
                compare = true;
            }
        }
        return compare;
    }

    private static boolean tryParseInt(String firstAttrValue, String secondAttrValue) {
        try {
            Double.parseDouble(firstAttrValue);
            Double.parseDouble(secondAttrValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

