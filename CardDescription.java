/**
 * Created by Jack on 31/08/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    public BufferedImage cardPicture;

    public CardDescription(String title, String chemistry, String classification,
                           String crystalSystem, String occurrence, double hardness,
                           double specificGravity, String cleavage, String crustalAbundance,
                           String economicValue, BufferedImage cardPic) {
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
        cardPicture = cardPic;
    }

    public CardDescription(String title, String economicValue, BufferedImage cardPic) {
        cardTitle = title;
        cardEconomicValue = economicValue;
        cardPicture = cardPic;
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

    //Tries to convert the input to a double
    private static boolean tryParseInt(String firstAttrValue, String secondAttrValue) {
        try {
            Double.parseDouble(firstAttrValue);
            Double.parseDouble(secondAttrValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ImageIcon getCardImage() {
        Image scaledImg = cardPicture.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(scaledImg);
        return imgIcon;
    }
}

