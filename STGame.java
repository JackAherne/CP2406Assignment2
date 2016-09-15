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

        if (chosenCard.getClass() == TrumpCard.class) {
            //switch(chosenCard) {
            //TODO case: chosenCard.cardTitle ==
            //}
            //int attributeChoice = economicValue;
            return String.valueOf(0);
        } else {
            System.out.println("Please choose an attribute: 1. Hardness  2. Specific Gravity  3. Cleavage  4. Crustal Abundance  5. Economic Value");
            int attributeChoice = reader.nextInt();
            //TODO while loop for < 2 || > 5
            switch (attributeChoice) {
                case 1:
                    System.out.println("You chose hardness of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardHardness);
                    return String.valueOf(chosenCard.cardHardness);
                case 2:
                    System.out.println("You chose specific gravity of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardSpecificGravity);
                    return String.valueOf(chosenCard.cardSpecificGravity);
                case 3:
                    System.out.println("You chose cleavage of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCleavage);
                    return chosenCard.cardCleavage;
                case 4:
                    System.out.println("You chose crustal abundance of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardCrustalAbundance);
                    return chosenCard.cardCrustalAbundance;
                case 5:
                    System.out.println("You chose economic value of " + chosenCard.cardTitle + " which has a value of " + chosenCard.cardEconomicValue);
                    return chosenCard.cardEconomicValue;
            }
            players[0].hand.remove(cardChoice);
        }
        return null;
    }

    public String botFirstTurn(int dealerID){
        int botChoice = 0;
        CardDescription botCard = players[dealerID - 1].hand.get(botChoice);

        if (botCard.getClass() == TrumpCard.class) {
            //switch(botCard) {
            // TODO case: botCard.cardTitle ==
           // }
            return String.valueOf(0);
        } else {
            Random rand = new Random();

            int attributeChoice = rand.nextInt(5);

            switch (attributeChoice) {
                case 1:
                    System.out.println("Bot chose hardness of " + botCard.cardTitle + " which has a value of " + botCard.cardHardness);
                    return String.valueOf(botCard.cardHardness);
                case 2:
                    System.out.println("Bot chose specific gravity of " + botCard.cardTitle + " which has a value of " + botCard.cardSpecificGravity);
                    return String.valueOf(botCard.cardSpecificGravity);
                case 3:
                    System.out.println("Bot chose cleavage of " + botCard.cardTitle + " which has a value of " + botCard.cardCleavage);
                    return botCard.cardCleavage;
                case 4:
                    System.out.println("Bot chose crustal abundance of " + botCard.cardTitle + " which has a value of " + botCard.cardCrustalAbundance);
                    return botCard.cardCrustalAbundance;
                case 5:
                    System.out.println("Bot chose economic value of " + botCard.cardTitle + " which has a value of " + botCard.cardEconomicValue);
                    return botCard.cardEconomicValue;
            }
        }
        return null;
    }

    public String playerTurn(){

    }
}



//if(thecardtheyplay.compareCards(attributeChoice, lastCard))
//for (int i = 0; i < )