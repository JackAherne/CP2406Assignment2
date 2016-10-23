/**
 * Created by Jack on 9/10/2016.
 */

import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GUI extends JPanel implements ActionListener {

    private static STGame game;
    public static JLabel cardDeck = new JLabel("");

    static void createAndShowGUI() {

        //Sets up the welcome screen.
        Font comicSans = new Font("Comic Sans MS", Font.PLAIN, 20);
        JPanel humanPanel = new JPanel();
        humanPanel.setLayout(new BorderLayout());

        JPanel northHumanPanel = new JPanel();
        northHumanPanel.setBackground(Color.CYAN);
        JPanel southHumanPanel = new JPanel(new BorderLayout());
        southHumanPanel.setBackground(Color.CYAN);
        JLabel playedCards = new JLabel();

        humanPanel.add(northHumanPanel, BorderLayout.NORTH);
        humanPanel.add(southHumanPanel, BorderLayout.SOUTH);
        humanPanel.add(playedCards, BorderLayout.CENTER);

        JFrame frame = new JFrame("Super Trump Game");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(humanPanel, BorderLayout.SOUTH);

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.CYAN);
        northPanel.setLayout(new BorderLayout());
        frame.add(northPanel, BorderLayout.NORTH);

        JPanel panelContainer = new JPanel();
        panelContainer.setBackground(Color.CYAN);
        panelContainer.setLayout(new BorderLayout());
        frame.add(panelContainer);

        JLabel superTrump = new JLabel("Super Trump Game");
        superTrump.setBackground(Color.CYAN);
        superTrump.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        superTrump.setHorizontalAlignment(JLabel.CENTER);
        panelContainer.add(superTrump, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.CYAN);
        panelContainer.add(centerPanel, BorderLayout.CENTER);

        JLabel welcomeLabel = new JLabel("How many players would you like to play against?");
        welcomeLabel.setBackground(Color.CYAN);
        welcomeLabel.setFont(comicSans);
        centerPanel.add(welcomeLabel);

        TextField numOfPlayers = new TextField();
        numOfPlayers.setColumns(5);
        centerPanel.add(numOfPlayers);

        //Sets up the game screen after new game has been pressed.
        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(comicSans);
        newGameButton.addActionListener(e -> {
            centerPanel.remove(centerPanel);
            centerPanel.remove(numOfPlayers);
            centerPanel.remove(welcomeLabel);
            centerPanel.remove(newGameButton);
            panelContainer.remove(superTrump);

            String numberOfPlayers = numOfPlayers.getText();

            int input = Integer.parseInt(numberOfPlayers);
            game = null;
            try {
                game = new STGame(input);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            game.dealCards(input);
            Player humanPlayer = Player.human;
            AIPlayer bot1 = AIPlayer.bots[0];
            AIPlayer bot2 = AIPlayer.bots[1];
            AIPlayer bot3 = AIPlayer.bots[2];

            BotView view1 = null;
            try {
                view1 = new BotView(bot1);
                view1.setBackground(Color.green);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            BotView view2 = null;
            try {
                view2 = new BotView(bot2);
                view2.setBackground(Color.CYAN);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            BotView view3 = null;
            try {
                view3 = new BotView(bot3);
                view3.setBackground(Color.green);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            northPanel.add(view1, BorderLayout.WEST);
            northPanel.add(view2, BorderLayout.CENTER);
            northPanel.add(view3, BorderLayout.EAST);

            JLabel currentAttribute = new JLabel("Current Attribute: ");
            currentAttribute.setFont(comicSans);
            currentAttribute.setHorizontalAlignment(JLabel.CENTER);
            northPanel.add(currentAttribute, BorderLayout.SOUTH);

            PlayerView view = new PlayerView(humanPlayer);

            //Changes the playing attribute to whatever button is pressed.
            JButton hardness = new JButton("Hardness");
            hardness.setFont(comicSans);
            hardness.addActionListener(e1 -> {
                String attribute = hardness.getActionCommand();
                STGame.player.setAttribute(attribute);
                currentAttribute.setText("Current Attribute: Hardness");
            });

            JButton specificGravity = new JButton("Specific Gravity");
            specificGravity.setFont(comicSans);
            specificGravity.addActionListener(e2 -> {
                String attribute = specificGravity.getActionCommand();
                STGame.player.setAttribute(attribute);
                currentAttribute.setText("Current Attribute: Specific Gravity");
            });

            JButton cleavage = new JButton("Cleavage");
            cleavage.setFont(comicSans);
            cleavage.addActionListener(e3 -> {
                String attribute = cleavage.getActionCommand();
                STGame.player.setAttribute(attribute);
                currentAttribute.setText("Current Attribute: Cleavage");
            });

            JButton crustalAbundance = new JButton("Crustal Abundance");
            crustalAbundance.setFont(comicSans);
            crustalAbundance.addActionListener(e4 -> {
                String attribute = crustalAbundance.getActionCommand();
                STGame.player.setAttribute(attribute);
                currentAttribute.setText("Current Attribute: Crustal Abundance");
            });

            JButton economicValue = new JButton("Econimic Value");
            economicValue.setFont(comicSans);
            economicValue.addActionListener(e5 -> {
                String attribute = economicValue.getActionCommand();
                STGame.player.setAttribute(attribute);
                currentAttribute.setText("Current Attribute: Economic Value");
            });

            ButtonGroup group = new ButtonGroup();
            group.add(hardness);
            group.add(specificGravity);
            group.add(cleavage);
            group.add(crustalAbundance);
            group.add(economicValue);

            //Passes the persons turned if the pass turn button is pressed.
            JButton passButton = new JButton("Pass");
            passButton.setFont(comicSans);
            passButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    southHumanPanel.removeAll();
                    Player.human.pass();
                    PlayerView view = new PlayerView(humanPlayer);
                    southHumanPanel.add(view, BorderLayout.CENTER);
                    southHumanPanel.add(passButton, BorderLayout.NORTH);
                    JPanel southHumanButtonPanel = new JPanel();
                    southHumanPanel.add(southHumanButtonPanel, BorderLayout.SOUTH);

                    southHumanButtonPanel.add(hardness, BorderLayout.SOUTH);
                    southHumanButtonPanel.add(specificGravity);
                    southHumanButtonPanel.add(cleavage);
                    southHumanButtonPanel.add(crustalAbundance);
                    southHumanButtonPanel.add(economicValue);
                    southHumanPanel.repaint();
                    southHumanPanel.revalidate();
                }
            });

            northHumanPanel.add(cardDeck, BorderLayout.CENTER);
            JPanel southHumanButtonPanel = new JPanel();
            southHumanButtonPanel.setBackground(Color.CYAN);
            southHumanPanel.add(southHumanButtonPanel, BorderLayout.SOUTH);
            southHumanPanel.setBackground(Color.CYAN);
            view.setBackground(Color.green);
            southHumanButtonPanel.add(hardness, BorderLayout.SOUTH);
            southHumanButtonPanel.add(specificGravity);
            southHumanButtonPanel.add(cleavage);
            southHumanButtonPanel.add(crustalAbundance);
            southHumanButtonPanel.add(economicValue);
            southHumanPanel.add(passButton, BorderLayout.NORTH);
            southHumanPanel.add(view, BorderLayout.CENTER);
            frame.repaint();
            frame.revalidate();
        });
        centerPanel.add(newGameButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //Adds cards to the played cards deck.
    public void addCardToDeck(CardDescription card) {
        cardDeck.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon imgCard = card.getDeckImage();
        cardDeck.setIcon(imgCard);
        cardDeck.repaint();
        cardDeck.revalidate();
    }
}