/**
 * Created by Jack on 4/09/2016.
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class STGame {
    public int numberOfPlayers;
    public int dealerID;
    public Deck deck;
    public Player[] players;
    public CardDescription card;
    public String currentAttribute;

    public STGame(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        this.deck = new Deck();
        //System.out.println(deck);
    }

    public int selectDealer(int numberOfPlayers) {

        Random generator = new Random();
        dealerID = generator.nextInt(numberOfPlayers);

        if (dealerID == 0) {
            dealerID =+ 1;
        }
        return dealerID;
    }

    public void dealCards(int numberOfPlayers){
        players = new Player[numberOfPlayers];
        ArrayList<CardDescription> playerHand;

        for (int i = 0; i < numberOfPlayers; i++){

            Player player = new Player();
            players[i] = player;
            playerHand = deck.returnHand();
            player.setHand(playerHand);
        }
    }

    public int determineFirstPlayer(int dealerID){
        return dealerID - 1;
    }

    public String playerFirstTurn() {

        System.out.println(players[0].hand);
        System.out.println("Input a number relating to card in hand position: ");

        Scanner reader = new Scanner(System.in);
        int cardChoice = Integer.parseInt(reader.next());

        System.out.println(players[0].hand.get(cardChoice));

        CardDescription chosenCard = players[0].hand.get(cardChoice);

        if (chosenCard.getClass() == TrumpCard.class) {
            playTrump(chosenCard);
        } else {
            System.out.println("Please choose an attribute: 1. Hardness  2. Specific Gravity  3. Cleavage  4. Crustal Abundance  5. Economic Value");
            int attributeChoice = reader.nextInt();
            //TODO while loop for < 1 || > 5

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
            deck.playedCards.add(players[0].hand.get(cardChoice));
            players[0].hand.remove(cardChoice);
        }
        isGameOver();
        return currentAttribute;
    }

    /**public void botFirstTurn(){

        int botChoice = 0;
        String attribute = "";
        CardDescription botCard = players[1].hand.get(botChoice);
        deck.playedCards.add(botCard);
        System.out.println(players[1].hand);

        if (botCard.getClass() == TrumpCard.class) {
            //switch(botCard) {
            // TODO case: botCard.cardTitle ==
           // }
        } else {
            Random rand = new Random();
            //int attributeChoice = rand.nextInt(5);

            currentAttribute = "Hardness";
            switch (currentAttribute) {
                case "Hardness":
                    System.out.println("Bot chose hardness of " + botCard.cardTitle + " which has a value of " + botCard.cardHardness);
                    break;
                case 2:
                    System.out.println("Bot chose specific gravity of " + botCard.cardTitle + " which has a value of " + botCard.cardSpecificGravity);
                    break;
                case 3:
                    System.out.println("Bot chose cleavage of " + botCard.cardTitle + " which has a value of " + botCard.cardCleavage);
                    break;
                case 4:
                    System.out.println("Bot chose crustal abundance of " + botCard.cardTitle + " which has a value of " + botCard.cardCrustalAbundance);
                    break;
                case 5:
                    System.out.println("Bot chose economic value of " + botCard.cardTitle + " which has a value of " + botCard.cardEconomicValue);
                    break;
            }
        }
        players[1].hand.remove(botChoice);
        isGameOver();
    }
     **/

    public void playerTurn(){

        Scanner reader = new Scanner(System.in);
        System.out.println("0. To pass.\n 1. To play.");
        int passOrPlay = Integer.parseInt(reader.next());

        if (passOrPlay == 0) {
            players[0].hand.add(deck.passTurn());
            System.out.println("You have decided to pass and have picked up " + players[0].hand.get(players[0].hand.size() - 1));
            System.out.println(players[0].hand);
        }
        else {
            if (currentAttribute.equals("Hardness")) {

                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardHardness);

                System.out.println("The attribute is Hardness, play a card with a higher hardness value or a Trump Card to change the attribute.");
                System.out.println(players[0].hand);

                int cardChoice = Integer.parseInt(reader.next());
                CardDescription chosenCard = players[0].hand.get(cardChoice);

                if (chosenCard.getClass() == TrumpCard.class){
                    playTrump(chosenCard);
                }

                String firstAttrValue = Double.toString(players[0].hand.get(cardChoice).cardHardness);
                System.out.println(firstAttrValue + " " + secondAttrValue);

                while (!CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                    System.out.println("That cards hardness is lower than the played card, choose again:");
                    cardChoice = Integer.parseInt(reader.next());
                    firstAttrValue = Double.toString(players[0].hand.get(cardChoice).cardHardness);
                    card.compareCards(firstAttrValue, secondAttrValue);
                }
                deck.playedCards.remove(0);
                deck.playedCards.add(players[0].hand.get(cardChoice));
                players[0].hand.remove(cardChoice);
            }
        }
        isGameOver();
    }

    public void botTurn() {
        int x;
        System.out.println(players[1].hand);
        for (x = 0; x < players[1].hand.size() + 1; x++) {
            if (currentAttribute.equals("Hardness")) {
                String secondAttrValue = Double.toString(deck.playedCards.get(0).cardHardness);
                String firstAttrValue;
                if (x < players[1].hand.size()) {
                    firstAttrValue = Double.toString(players[1].hand.get(x).cardHardness);
                    System.out.println("Test: " + firstAttrValue + " " + secondAttrValue);
                    if (CardDescription.compareCards(firstAttrValue, secondAttrValue)) {
                        System.out.println("Test: " + CardDescription.compareCards(firstAttrValue, secondAttrValue));
                        deck.playedCards.remove(0);
                        deck.playedCards.add(players[1].hand.get(x));

                        System.out.println("Bot played " + players[1].hand.get(x));

                        players[1].hand.remove(x);
                        System.out.println("first x: " + x);
                        x = players[1].hand.size() + 2;
                    }
                }
                System.out.println("second x: " + x);
            }
        }
        if (x == players[1].hand.size() + 1) {
            players[1].hand.add(deck.passTurn());
            System.out.println("The bot picked up");
            System.out.println(players[1].hand);
            System.out.println("third x: " + x);
        }
        isGameOver();
    }

    public void isGameOver() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i].hand.size() == 0) {
                if (i == 0) {
                    System.out.println("You won, congratulations.");
                    System.exit(0);
                } else {
                    System.out.println("Bot " + i + " wins.");
                    System.exit(0);
                }
            } else if (deck.isDeckEmpty()) {
                System.out.println("Deck is empty, nobody wins.");
                System.exit(0);
            }
        }
    }

    public void playTrump(CardDescription chosenCard) {
        deck.playedCards.remove(0);
        Scanner reader = new Scanner(System.in);

        if (chosenCard.cardTitle.equals("The Geologist")) {
            System.out.println("Please choose which category you wish to change it to: 1. Hardness \n 2. Specific Gravity \n 3. Cleavage \n 4. Crustal Abundance \n 5. Economic Value");
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
            System.out.println("You have chosen " + chosenCard.cardTitle + " which changes the category to Specific Gravity.");
            currentAttribute = "Specific Gravity";
        }
        else
        {
            System.out.println("You have chosen " + chosenCard.cardTitle + " which changes the category to " + chosenCard.cardEconomicValue + ".");
            currentAttribute = chosenCard.cardEconomicValue;
        }
    }

    public void botPlayTrump(CardDescription chosenCard) {
        deck.playedCards.remove(0);
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();

        if (chosenCard.cardTitle.equals("The Geologist")) {
            int attributeChoice = rand.nextInt(5 - 1) + 1;
            switch (attributeChoice) {
                case 1:
                    System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to Hardness.");
                    currentAttribute = "Hardness";
                    break;
                case 2:
                    System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to Specific Gravity.");
                    currentAttribute = "SpecificGravity";
                    break;
                case 3:
                    System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to Cleavage.");
                    currentAttribute = "Cleavage";
                    break;
                case 4:
                    System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to Crustal Abundance.");
                    currentAttribute = "CrustalAbundance";
                    break;
                case 5:
                    System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to Economic Value.");
                    currentAttribute = "EconomicValue";
                    break;
            }
        }
        else if (chosenCard.cardTitle.equals("The Geophysicist")){
            System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to Specific Gravity.");
            currentAttribute = "Specific Gravity";
        }
        else
        {
            System.out.println("The bot chose " + chosenCard.cardTitle + " which changes the category to " + chosenCard.cardEconomicValue + ".");
            currentAttribute = chosenCard.cardEconomicValue;
        }
    }
}



//if(thecardtheyplay.compareCards(attributeChoice, lastCard))
//for (int i = 0; i < )