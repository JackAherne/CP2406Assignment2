/**
 * Created by Jack on 10/09/2016.
 */
import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;
public class AIPlayer extends Player{


    public void botFirstTurnPlayCard(int firstPlayer) {
        //Makes sure there are no cards in the played cards deck
        try {
            deck.playedCards.remove(0);

        } catch (IndexOutOfBoundsException e) {
            int botChoice = 0;

            CardDescription botCard = bots[firstPlayer].hand.get(botChoice);

            if (botCard.getClass() == TrumpCard.class) {
                botPlayTrump(firstPlayer);
            } else {
                Random rand = new Random();
                int randomChoice = rand.nextInt(5);


                switch (randomChoice) {
                    case 1:
                        System.out.println("Bot " + firstPlayer + " chose hardness of " + botCard.cardTitle + " which has a value of " + botCard.cardHardness);
                        currentAttribute = "Hardness";
                        break;
                    case 2:
                        System.out.println("Bot " + firstPlayer + " specific gravity of " + botCard.cardTitle + " which has a value of " + botCard.cardSpecificGravity);
                        currentAttribute = "Specific Gravity";
                        break;
                    case 3:
                        System.out.println("Bot " + firstPlayer + " chose cleavage of " + botCard.cardTitle + " which has a value of " + botCard.cardCleavage);
                        currentAttribute = "Cleavage";
                        break;
                    case 4:
                        System.out.println("Bot " + firstPlayer + " chose crustal abundance of " + botCard.cardTitle + " which has a value of " + botCard.cardCrustalAbundance);
                        currentAttribute = "Crustal Abundance";
                        break;
                    case 5:
                        System.out.println("Bot " + firstPlayer + " economic value of " + botCard.cardTitle + " which has a value of " + botCard.cardEconomicValue);
                        currentAttribute = "Economic Value";
                        break;
                }
            }
            deck.playedCards.add(botCard);
            bots[firstPlayer].hand.remove(botChoice);
        }
    }


    public CardDescription botPlayCard(int i) {
        //Decides what card the bot plays depending on current attribute.
        CardDescription botCard = card;
        for (int x = 0; x < bots[i].hand.size() + 1; x++) {
            if (currentAttribute.equals("Hardness")) {
                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardHardness);
                String firstAttrValue;
                if (x < bots[i].hand.size()) {
                    if (bots[i].hand.get(x).getClass() == TrumpCard.class) {
                        x += 1;
                    }
                    else {
                        firstAttrValue = Double.toString(bots[i].hand.get(x).cardHardness);
                        System.out.println("Bot " + i + " First Attribute value: " + firstAttrValue + " Comparing to Second Attribute value: " + secondAttrValue);
                        if (CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("Test what compareCards returns: " + CardDescription.compareCards(firstAttrValue, secondAttrValue));
                            deck.playedCards.remove(0);
                            deck.playedCards.add(bots[i].hand.get(x));

                            System.out.println("Bot played " + bots[i].hand.get(x));

                            botCard = bots[i].hand.get(x);
                            bots[i].hand.remove(x);
                            x = bots[i].hand.size() + 2;
                        } else {
                            System.out.println("false");
                        }
                    }
                }
            }
            else if (currentAttribute.equals("Specific Gravity")) {
                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardSpecificGravity);
                String firstAttrValue;
                if (x < bots[i].hand.size()) {
                    if (bots[i].hand.get(x).getClass() == TrumpCard.class) {
                        x += 1;
                    }
                    else {
                        firstAttrValue = Double.toString(bots[i].hand.get(x).cardSpecificGravity);
                        System.out.println("Bot " + i + " First Attribute value: " + firstAttrValue + " Comparing to Second Attribute value: " + secondAttrValue);
                        if (CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("Test: " + CardDescription.compareCards(firstAttrValue, secondAttrValue));
                            deck.playedCards.remove(0);
                            deck.playedCards.add(bots[i].hand.get(x));

                            System.out.println("Bot played " + bots[i].hand.get(x));

                            botCard = bots[i].hand.get(x);
                            bots[i].hand.remove(x);
                            x = bots[i].hand.size() + 2;
                        }
                    }
                }
            }
            else if(currentAttribute.equals("Cleavage")){
                //Creates a dictionary of values relating to attributes that have string values so they can be compared.
                Map<String, Integer> cleavageDictionary = new HashMap<String, Integer>();
                cleavageDictionary.put("none", 0);
                cleavageDictionary.put("poor/none", 1);
                cleavageDictionary.put("1 poor", 2);
                cleavageDictionary.put("2 poor", 3);
                cleavageDictionary.put("1 good", 4);
                cleavageDictionary.put("1 good, 1 poor", 5);
                cleavageDictionary.put("2 good", 6);
                cleavageDictionary.put("3 good", 7);
                cleavageDictionary.put("1 perfect", 8);
                cleavageDictionary.put("1 perfect, 1 good", 9);
                cleavageDictionary.put("1 perfect, 2 good", 10);
                cleavageDictionary.put("2 perfect",11);
                cleavageDictionary.put("3 perfect",12);
                cleavageDictionary.put("4 perfect",13);
                cleavageDictionary.put("6 perfect",14);
                String secondAttrValue = String.valueOf(cleavageDictionary.get(deck.playedCards.get(0).cardCleavage));

                String firstAttrValue;
                if (x < bots[i].hand.size()) {
                    System.out.println("i is : " + i);
                    System.out.println("x is : " + x);
                    if (bots[i].hand.get(x).getClass() == TrumpCard.class) {
                        x += 1;
                    }
                    else {
                        firstAttrValue = Integer.toString(cleavageDictionary.get(bots[i].hand.get(x).cardCleavage));
                        System.out.println("Bot " + i + " First Attribute value: " + firstAttrValue + " Comparing to Second Attribute value: " + secondAttrValue);
                        if (CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("Test what compareCards returns: " + CardDescription.compareCards(firstAttrValue, secondAttrValue));
                            deck.playedCards.remove(0);
                            deck.playedCards.add(bots[i].hand.get(x));

                            System.out.println("Bot played " + bots[i].hand.get(x));
                            botCard = bots[i].hand.get(x);

                            bots[i].hand.remove(x);
                            x = bots[i].hand.size() + 2;
                        }
                    }
                }
            }
            else if (currentAttribute.equals("CrustalAbundance")) {
                //Creates a dictionary of values relating to attributes that have string values so they can be compared.
                Map<String, Integer> crustalAbundanceDictionary = new HashMap<String, Integer>();
                crustalAbundanceDictionary.put("ultratrace", 0);
                crustalAbundanceDictionary.put("trace", 1);
                crustalAbundanceDictionary.put("low", 2);
                crustalAbundanceDictionary.put("moderate", 3);
                crustalAbundanceDictionary.put("high", 4);
                crustalAbundanceDictionary.put("very high", 5);

                String secondAttrValue = Integer.toString(crustalAbundanceDictionary.get(deck.playedCards.get(0).cardCrustalAbundance));
                String firstAttrValue;
                if (x < bots[i].hand.size()) {
                    System.out.println("i is : " + i);
                    System.out.println("x is : " + x);
                    if (bots[i].hand.get(x).getClass() == TrumpCard.class) {
                        x += 1;
                    } else {
                        firstAttrValue = Integer.toString(crustalAbundanceDictionary.get(bots[i].hand.get(x).cardCrustalAbundance));
                        System.out.println("Bot " + i + " First Attribute value: " + firstAttrValue + " Comparing to Second Attribute value: " + secondAttrValue);
                        if (CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("Test what compareCards returns: " + CardDescription.compareCards(firstAttrValue, secondAttrValue));
                            deck.playedCards.remove(0);
                            deck.playedCards.add(bots[i].hand.get(x));

                            System.out.println("Bot played " + bots[i].hand.get(x));

                            botCard = bots[i].hand.get(x);

                            bots[i].hand.remove(x);
                            x = bots[i].hand.size() + 2;
                        }
                    }
                }
            }
            else if (currentAttribute.equals("EconomicValue")) {
                //Creates a dictionary of values relating to attributes that have string values so they can be compared.
                Map<String, Integer> economicValueDictionary = new HashMap<String, Integer>();
                economicValueDictionary.put("trivial", 0);
                economicValueDictionary.put("low", 1);
                economicValueDictionary.put("moderate", 2);
                economicValueDictionary.put("high", 3);
                economicValueDictionary.put("very high", 4);
                economicValueDictionary.put("I'm rich!", 5);

                String secondAttrValue = Integer.toString(economicValueDictionary.get(deck.playedCards.get(0).cardEconomicValue));
                String firstAttrValue;
                if (x < bots[i].hand.size()) {
                    System.out.println("i is : " + i);
                    System.out.println("x is : " + x);
                    if (bots[i].hand.get(x).getClass() == TrumpCard.class) {
                        x += 1;
                    } else {
                        firstAttrValue = Integer.toString(economicValueDictionary.get(bots[i].hand.get(x).cardEconomicValue));
                        System.out.println("Bot " + i + " First Attribute value: " + firstAttrValue + " Comparing to Second Attribute value: " + secondAttrValue);
                        if (CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("Test what compareCards returns: " + CardDescription.compareCards(firstAttrValue, secondAttrValue));
                            deck.playedCards.remove(0);
                            deck.playedCards.add(bots[i].hand.get(x));

                            System.out.println("Bot played " + bots[i].hand.get(x));

                            botCard = bots[i].hand.get(x);

                            bots[i].hand.remove(x);
                            x = bots[i].hand.size() + 2;
                        }
                    }
                }
            }
            else if (x == bots[i].hand.size()) {
                System.out.println("x went above hand size, trying to play trump card");
                if (!botPlayTrump(i)) {
                    bots[i].hand.add(deck.passTurn());
                    System.out.println("The bot picked up.");
                    System.out.println(bots[i].hand);
                }
            }
        }
        return botCard;
    }

    //If the bot has no mineral card to play, it checks to see if it has a trump card and will play that card
    public boolean botPlayTrump(int i) {
        if (!deck.playedCards.isEmpty()) {
            deck.playedCards.remove(0);
        }
        Random rand = new Random();
        int x;
        for (x = 0; x < Player.bots[i].hand.size(); x++) {
            CardDescription currentCard = bots[i].hand.get(x);

            if (currentCard.cardTitle.equals("The Geologist")) {
                int attributeChoice = rand.nextInt(5 - 1) + 1;
                switch (attributeChoice) {
                    case 1:
                        System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to Hardness.");
                        currentAttribute = "Hardness";
                        break;
                    case 2:
                        System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to Specific Gravity.");
                        currentAttribute = "SpecificGravity";
                        break;
                    case 3:
                        System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to Cleavage.");
                        currentAttribute = "Cleavage";
                        break;
                    case 4:
                        System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to Crustal Abundance.");
                        currentAttribute = "CrustalAbundance";
                        break;
                    case 5:
                        System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to Economic Value.");
                        currentAttribute = "EconomicValue";
                        break;
                }
                System.out.println(bots[i].hand.get(x).cardTitle + " was removed");
                bots[i].hand.remove(x);
            }
            else if (currentCard.cardTitle.equals("The Geophysicist")) {
                int k;
                for (k = 0; k < bots[i].hand.size(); i++) {
                   if (bots[i].hand.get(i).cardTitle.equals("Magnetite")) {
                       System.out.println("The bot " + i + " has played The Geophycisit and the Magnetite card. Bot " + i + " wins." );
                   }
                }
                System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to Specific Gravity.");
                currentAttribute = "Specific Gravity";
                System.out.println(bots[i].hand.get(x).cardTitle + " was removed");
                bots[i].hand.remove(x);
            } else {
                System.out.println("The bot " + i + " chose " + currentCard.cardTitle + " which changes the category to " + currentCard.cardEconomicValue + ".");
                currentAttribute = currentCard.cardEconomicValue;
                System.out.println(bots[i].hand.get(x).cardTitle + " was removed");
                bots[i].hand.remove(x);
            }
        }
        if (x == bots[i].hand.size() + 1) {
            System.out.println("x went above hand size");
            return false;
        }
        else {
            System.out.println("A trump card was played");
            return true;
        }
    }

    public ArrayList<CardDescription> getHand() {
       // ArrayList hands = new ArrayList<>();
      //  ArrayList cards = new ArrayList<CardDescription>();
      //  cards.set(0, bots[0].hand);
      //  cards.set(1, bots[1].hand);
      //  cards.set(2, bots[2].hand);
      //  hands.add(cards);
      //  hands.add(bots[2].hand);
        return hand;
    }
}
