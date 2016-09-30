/**
 * Created by Jack on 7/09/2016.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {

    public static String currentAttribute;
    public static Player human;
    public static AIPlayer[] bots;
    public ArrayList<CardDescription> hand;
    public Deck deck = STGame.deck;
    public CardDescription card = STGame.card;

    public void setHand(ArrayList<CardDescription> hand) {
        this.hand = hand;
    }


    public void playerFirstTurnPlayCard() {
        try {
            deck.playedCards.remove(0);

        } catch (IndexOutOfBoundsException e) {

            System.out.println(human.hand);
            System.out.println("Input a number relating to card in hand position: ");

            Scanner reader = new Scanner(System.in);
            int cardChoice = Integer.parseInt(reader.next());

            System.out.println(human.hand.get(cardChoice));

            CardDescription chosenCard = human.hand.get(cardChoice);
            if (chosenCard.getClass() == TrumpCard.class) {
                while (chosenCard.getClass() == TrumpCard.class) {
                    System.out.println("Can't play a trump card on the opening hand. Choose another card.");
                    cardChoice = Integer.parseInt((reader.next()));
                    chosenCard = human.hand.get(cardChoice);
                    //playTrump(chosenCard);
                }
            }
            System.out.println("Please choose an attribute: 1. Hardness  2. Specific Gravity  3. Cleavage  4. Crustal Abundance  5. Economic Value");
            int attributeChoice = reader.nextInt();
            while (attributeChoice < 1 || attributeChoice > 5) {
                System.out.println("Please enter: 1. Hardness  2. Specific Gravity  3. Cleavage  4. Crustal Abundance  5. Economic Value");
                attributeChoice = reader.nextInt();
            }

            switch (attributeChoice) {
                case 1:
                    System.out.println("You chose hardness of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardHardness + ".");
                    Player.currentAttribute = "Hardness";
                    break;
                case 2:
                    System.out.println("You chose specific gravity of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardSpecificGravity + ".");
                    Player.currentAttribute = "SpecificGravity";
                    break;
                case 3:
                    System.out.println("You chose cleavage of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCleavage + ".");
                    Player.currentAttribute = "Cleavage";
                    break;
                case 4:
                    System.out.println("You chose crustal abundance of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCrustalAbundance + ".");
                    Player.currentAttribute = "CrustalAbundance";
                    break;
                case 5:
                    System.out.println("You chose economic value of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardEconomicValue + ".");
                    Player.currentAttribute = "EconomicValue";
                    break;
            }
            deck.playedCards.add(human.hand.get(cardChoice));
            human.hand.remove(cardChoice);
            System.out.println("The current attribute is: " + currentAttribute);
        }
    }


    public void playerPlayCard() {
        System.out.println(human.hand);
        String firstAttrValue;
        Scanner reader = new Scanner(System.in);
        System.out.println("0. To pass.\n 1. To play.");
        int passOrPlay = Integer.parseInt(reader.next());

        if (passOrPlay == 0) {
            human.hand.add(deck.passTurn());
            System.out.println("You have decided to pass and have picked up " + human.hand.get(human.hand.size() - 1));
            System.out.println(human.hand);
        } else {
            if (currentAttribute.equals("Hardness")) {

                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardHardness);

                System.out.println("The attribute is Hardness, play a card with a hardness higher than " + secondAttrValue + " or a Trump Card to change the attribute.\n or type pass to pass");
                System.out.println(human.hand);

                String cardChoiceCheck = String.valueOf(reader.next());

                if (cardChoiceCheck.equals("pass")) {
                    System.out.println("You have passed and picked up " + human.hand.get(human.hand.size() - 1));
                    human.hand.add(deck.passTurn());
                } else {
                    int cardChoice = Integer.parseInt(cardChoiceCheck);

                    CardDescription chosenCard = human.hand.get(cardChoice);

                    if (chosenCard.getClass() == TrumpCard.class) {
                        playTrump(chosenCard);
                        human.hand.remove(cardChoice);
                    } else {
                        firstAttrValue = Double.toString(human.hand.get(cardChoice).cardHardness);
                        System.out.println(firstAttrValue + " " + secondAttrValue);

                        while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("That cards hardness is lower than the played card, choose again:");
                            cardChoice = Integer.parseInt(reader.next());
                            firstAttrValue = Double.toString(human.hand.get(cardChoice).cardHardness);
                            card.compareCards(firstAttrValue, secondAttrValue);
                        }
                        deck.playedCards.remove(0);
                        deck.playedCards.add(human.hand.get(cardChoice));
                        human.hand.remove(cardChoice);
                    }
                }
            } else if (currentAttribute.equals("Specific Gravity")) {

                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardSpecificGravity);

                System.out.println("The attribute is Specific Gravity, play a card with a hardness higher than " + secondAttrValue + " or a Trump Card to change the attribute.\n or type pass to pass");
                System.out.println(human.hand);

                String cardChoiceCheck = String.valueOf(reader.next());

                if (cardChoiceCheck.equals("pass")) {
                    System.out.println("You have passed and picked up " + human.hand.get(human.hand.size() - 1));
                    human.hand.add(deck.passTurn());
                } else {
                    int cardChoice = Integer.parseInt(cardChoiceCheck);
                    CardDescription chosenCard = human.hand.get(cardChoice);

                    if (chosenCard.getClass() == TrumpCard.class) {
                        playTrump(chosenCard);
                        human.hand.remove(cardChoice);
                    } else {
                        firstAttrValue = Double.toString(human.hand.get(cardChoice).cardSpecificGravity);
                        System.out.println(firstAttrValue + " " + secondAttrValue);

                        while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("That cards hardness is lower than the played card, choose again:");
                            cardChoice = Integer.parseInt(reader.next());
                            firstAttrValue = Double.toString(human.hand.get(cardChoice).cardSpecificGravity);
                            card.compareCards(firstAttrValue, secondAttrValue);
                        }
                        deck.playedCards.remove(0);
                        deck.playedCards.add(human.hand.get(cardChoice));
                        human.hand.remove(cardChoice);
                    }
                }
            } else if (currentAttribute.equals("Specific Gravity")) {

                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardSpecificGravity);

                System.out.println("The attribute is Specific Gravity, play a card with a hardness higher than " + secondAttrValue + " or a Trump Card to change the attribute.\n or type pass to pass");
                System.out.println(human.hand);

                String cardChoiceCheck = String.valueOf(reader.next());

                if (cardChoiceCheck.equals("pass")) {
                    System.out.println("You have passed and picked up " + human.hand.get(human.hand.size() - 1));
                    human.hand.add(deck.passTurn());
                } else {
                    int cardChoice = Integer.parseInt(cardChoiceCheck);
                    CardDescription chosenCard = human.hand.get(cardChoice);


                    if (chosenCard.getClass() == TrumpCard.class) {
                        playTrump(chosenCard);
                        human.hand.remove(cardChoice);
                    } else {
                        firstAttrValue = Double.toString(human.hand.get(cardChoice).cardSpecificGravity);
                        System.out.println(firstAttrValue + " " + secondAttrValue);

                        while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("That cards Specific Gravity is lower than the played card, choose again:");
                            cardChoice = Integer.parseInt(reader.next());
                            firstAttrValue = Double.toString(human.hand.get(cardChoice).cardSpecificGravity);
                            card.compareCards(firstAttrValue, secondAttrValue);
                        }
                        deck.playedCards.remove(0);
                        deck.playedCards.add(human.hand.get(cardChoice));
                        human.hand.remove(cardChoice);
                    }
                }
            } else if (currentAttribute.equals("Cleavage")) {
                Map<String, Integer> cleavageDictionary = new HashMap<String, Integer>();
                cleavageDictionary.put("none", 0);
                cleavageDictionary.put("poor/none", 1);
                cleavageDictionary.put("1 poor", 2);
                cleavageDictionary.put("2 poor", 3);
                cleavageDictionary.put("1 good", 4);
                cleavageDictionary.put("1 good, 1 poor", 5);
                cleavageDictionary.put("2 good", 6);
                cleavageDictionary.put("3 good", 7);
                cleavageDictionary.put("1 perf", 8);
                cleavageDictionary.put("1 perf, 1 good", 9);
                cleavageDictionary.put("1 perf, 2 good", 10);
                cleavageDictionary.put("2 perf", 11);
                cleavageDictionary.put("3 perf", 12);
                cleavageDictionary.put("4 perf", 13);
                cleavageDictionary.put("6 perf", 14);

                String secondAttrValue = Double.toString(cleavageDictionary.get(deck.playedCards.get(0).cardCleavage));

                System.out.println("The attribute is Cleavage, play a card with a Cleavage higher than " + secondAttrValue + " or a Trump Card to change the attribute.\n or type pass to pass");
                System.out.println(human.hand);

                String cardChoiceCheck = String.valueOf(reader.next());

                if (cardChoiceCheck.equals("pass")) {
                    System.out.println("You have passed and picked up " + human.hand.get(human.hand.size() - 1));
                    human.hand.add(deck.passTurn());
                } else {
                    int cardChoice = Integer.parseInt(cardChoiceCheck);
                    CardDescription chosenCard = human.hand.get(cardChoice);

                    if (chosenCard.getClass() == TrumpCard.class) {
                        playTrump(chosenCard);
                        human.hand.remove(cardChoice);
                    } else {
                        firstAttrValue = Integer.toString(cleavageDictionary.get(chosenCard.cardCleavage));
                        System.out.println(firstAttrValue + " " + secondAttrValue);

                        while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("That cards Cleavage is lower than the played card, choose again:");
                            cardChoice = Integer.parseInt(reader.next());
                            firstAttrValue = Integer.toString(cleavageDictionary.get(chosenCard.cardCleavage));
                            card.compareCards(firstAttrValue, secondAttrValue);
                        }
                        deck.playedCards.remove(0);
                        deck.playedCards.add(human.hand.get(cardChoice));
                        human.hand.remove(cardChoice);
                    }
                }
            } else if (currentAttribute.equals("Crustal Abundance")) {
                Map<String, Integer> crustalAbundanceDictionary = new HashMap<String, Integer>();
                crustalAbundanceDictionary.put("ultratrace", 0);
                crustalAbundanceDictionary.put("trace", 1);
                crustalAbundanceDictionary.put("low", 2);
                crustalAbundanceDictionary.put("moderate", 3);
                crustalAbundanceDictionary.put("high", 4);
                crustalAbundanceDictionary.put("very high", 5);

                String secondAttrValue = Integer.toString(crustalAbundanceDictionary.get(deck.playedCards.get(0).cardCrustalAbundance));

                System.out.println("The attribute is Crustal Abundance, play a card with a Crustal Abundance higher than " + secondAttrValue + " or a Trump Card to change the attribute.\n or type pass to pass");
                System.out.println(human.hand);

                String cardChoiceCheck = String.valueOf(reader.next());

                if (cardChoiceCheck.equals("pass")) {
                    System.out.println("You have passed and picked up " + human.hand.get(human.hand.size() - 1));
                    human.hand.add(deck.passTurn());
                } else {
                    int cardChoice = Integer.parseInt(cardChoiceCheck);
                    CardDescription chosenCard = human.hand.get(cardChoice);

                    if (chosenCard.getClass() == TrumpCard.class) {
                        playTrump(chosenCard);
                        human.hand.remove(cardChoice);
                    } else {
                        firstAttrValue = Integer.toString(crustalAbundanceDictionary.get(chosenCard.cardCrustalAbundance));
                        System.out.println(firstAttrValue + " " + secondAttrValue);

                        while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("That cards Crustal Abundance is lower than the played card, choose again:");
                            cardChoice = Integer.parseInt(reader.next());
                            firstAttrValue = Integer.toString(crustalAbundanceDictionary.get(chosenCard.cardCrustalAbundance));
                            card.compareCards(firstAttrValue, secondAttrValue);
                        }
                        deck.playedCards.remove(0);
                        deck.playedCards.add(human.hand.get(cardChoice));
                        human.hand.remove(cardChoice);
                    }
                }
            } else if (currentAttribute.equals("Economic Value")) {
                Map<String, Integer> economicValueDictionary = new HashMap<String, Integer>();
                economicValueDictionary.put("trivial", 0);
                economicValueDictionary.put("low", 1);
                economicValueDictionary.put("moderate", 2);
                economicValueDictionary.put("high", 3);
                economicValueDictionary.put("very high", 4);
                economicValueDictionary.put("I'm rich!", 5);

                String secondAttrValue = Integer.toString(economicValueDictionary.get(deck.playedCards.get(0).cardEconomicValue));

                System.out.println("The attribute is Economic Value, play a card with an Economic Value higher than " + secondAttrValue + " or a Trump Card to change the attribute.\n or type pass to pass");
                System.out.println(human.hand);

                String cardChoiceCheck = String.valueOf(reader.next());

                if (cardChoiceCheck.equals("pass")) {
                    System.out.println("You have passed and picked up " + human.hand.get(human.hand.size() - 1));
                    human.hand.add(deck.passTurn());
                } else {
                    int cardChoice = Integer.parseInt(cardChoiceCheck);
                    CardDescription chosenCard = human.hand.get(cardChoice);

                    if (chosenCard.getClass() == TrumpCard.class) {
                        playTrump(chosenCard);
                        human.hand.remove(cardChoice);
                    } else {
                        firstAttrValue = Integer.toString(economicValueDictionary.get(chosenCard.cardEconomicValue));
                        System.out.println(firstAttrValue + " " + secondAttrValue);

                        while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                            System.out.println("That cards Economic Value is lower than the played card, choose again:");
                            cardChoice = Integer.parseInt(reader.next());
                            firstAttrValue = Integer.toString(economicValueDictionary.get(chosenCard.cardCrustalAbundance));
                            card.compareCards(firstAttrValue, secondAttrValue);
                        }
                        deck.playedCards.remove(0);
                        deck.playedCards.add(human.hand.get(cardChoice));
                        human.hand.remove(cardChoice);
                    }
                }
            }
        }
    }


    public void playTrump(CardDescription chosenCard) {
        if (!deck.playedCards.isEmpty()) {
            deck.playedCards.remove(0);
        }

        Scanner reader = new Scanner(System.in);

        if (chosenCard.cardTitle.equals("The Geologist")) {
            System.out.println("Please choose which category you wish to change it to:\n 1. Hardness \n 2. Specific Gravity \n 3. Cleavage \n 4. Crustal Abundance \n 5. Economic Value");
            int attributeChoice = reader.nextInt();
            switch (attributeChoice) {
                case 1:
                    System.out.println("You chose hardness of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardHardness + ".");
                    currentAttribute = "Hardness";
                    break;
                case 2:
                    System.out.println("You chose specific gravity of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardSpecificGravity + ".");
                    currentAttribute = "SpecificGravity";
                    break;
                case 3:
                    System.out.println("You chose cleavage of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCleavage + ".");
                    currentAttribute = "Cleavage";
                    break;
                case 4:
                    System.out.println("You chose crustal abundance of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCrustalAbundance + ".");
                    currentAttribute = "CrustalAbundance";
                    break;
                case 5:
                    System.out.println("You chose economic value of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardEconomicValue + ".");
                    currentAttribute = "EconomicValue";
                    break;
            }
        }
        else if (chosenCard.cardTitle.equals("The Geophysicist")){
            Scanner reader2 = new Scanner(System.in);
            int i;
            for (i = 0; i < human.hand.size() + 1; i++) {
                if (human.hand.get(i).cardTitle.equals("Magnetite")) {
                    System.out.println("Press 1 to play the Magnetite Card and win the game.");
                    int choice = Integer.parseInt(reader2.next());
                    if (choice == 1) {
                        System.out.println("Congratulations, you win!");
                        System.exit(0);
                    }
                    else {
                        System.out.println("You have chosen " + chosenCard.cardTitle + " which changes the category to Specific Gravity.");
                        currentAttribute = "Specific Gravity";
                    }
                }
            }
        }
        else
        {
            System.out.println("You have chosen " + chosenCard.cardTitle + " which changes the category to " + chosenCard.cardEconomicValue + ".");
            currentAttribute = chosenCard.cardEconomicValue;
        }
    }
}
