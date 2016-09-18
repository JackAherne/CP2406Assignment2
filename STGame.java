/**
 * Created by Jack on 4/09/2016.
 */

import javax.smartcardio.Card;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class STGame {
    public int numberOfPlayers;
    public int dealerID;
    public Deck deck;
    public Player[] players;
    public CardDescription card;
    public int currentAttribute;

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
            //System.out.println("player[" + i + "]=" + computerHands);
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
        String attribute = "";

        if (chosenCard.getClass() == TrumpCard.class) {
            //switch(chosenCard) {
            //TODO case: chosenCard.cardTitle ==
            //}
            //int attributeChoice = economicValue;
            return String.valueOf(0);
        } else {
            System.out.println("Please choose an attribute: 1. Hardness  2. Specific Gravity  3. Cleavage  4. Crustal Abundance  5. Economic Value");
            int attributeChoice = reader.nextInt();
            //TODO while loop for < 1 || > 5
            switch (attributeChoice) {
                case 1:
                    System.out.println("You chose hardness of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardHardness);
                    attribute = String.valueOf(chosenCard.cardHardness) + " Hardness";
                    break;
                case 2:
                    System.out.println("You chose specific gravity of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardSpecificGravity);
                    attribute = String.valueOf(chosenCard.cardSpecificGravity) + " SpecificGravity";
                    break;
                case 3:
                    System.out.println("You chose cleavage of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCleavage);
                    attribute = chosenCard.cardCleavage + " Cleavage";
                    break;
                case 4:
                    System.out.println("You chose crustal abundance of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCrustalAbundance);
                    attribute = chosenCard.cardCrustalAbundance + " CurstalAbundance";
                    break;
                case 5:
                    System.out.println("You chose economic value of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardEconomicValue);
                    attribute = chosenCard.cardEconomicValue + " EconomicValue";
                    break;
            }
            players[0].hand.remove(cardChoice);
        }
        return attribute;
    }

    public void botFirstTurn(){
        int botChoice = 0;
        String attribute = "";
        CardDescription botCard = players[1].hand.get(botChoice);
        deck.playedCards.add(botCard);

        if (botCard.getClass() == TrumpCard.class) {
            //switch(botCard) {
            // TODO case: botCard.cardTitle ==
           // }
        } else {
            Random rand = new Random();
            //int attributeChoice = rand.nextInt(5);

            currentAttribute = 1;
            switch (currentAttribute) {
                case 1:
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
    }

    public void playerTurn(int currentAttribute){
        //TODO: return for trump card being played

        Scanner reader = new Scanner(System.in);

        if (currentAttribute == 1) {

            String botAttrValue = Double.toString(deck.playedCards.get(0).cardHardness);

            System.out.println("The attribute is Hardness, input a number that relates to a card in your hand:");
            System.out.println(players[0].hand);

            int cardChoice = Integer.parseInt(reader.next());
            String playerAttrValue = Double.toString(players[0].hand.get(cardChoice).cardHardness);
            System.out.println(playerAttrValue + " " + botAttrValue);
           // boolean compareResult = card.compareCards(playerAttrValue, botAttrValue);
           // System.out.println(compareResult);
            while (card.compareCards(playerAttrValue, botAttrValue) == false){
                System.out.println("That cards hardness is lower than the played card, choose again:");
                cardChoice = Integer.parseInt(reader.next());
                playerAttrValue = Double.toString(players[0].hand.get(cardChoice).cardHardness);
                card.compareCards(playerAttrValue, botAttrValue);
            }
            deck.playedCards.remove(0);
            deck.playedCards.add(players[0].hand.get(cardChoice));
        }
    }

    public void botTurn(){

    }
}



//if(thecardtheyplay.compareCards(attributeChoice, lastCard))
//for (int i = 0; i < )