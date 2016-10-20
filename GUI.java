/**
 * Created by Jack on 9/10/2016.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;


public abstract class GUI extends JPanel implements ActionListener {

    private static STGame game;

    public static void createAndShowGUI() {

        JPanel humanPanel = new JPanel();
        humanPanel.setLayout(new BorderLayout());

        JPanel northHumanPanel = new JPanel();
        JPanel southHumanPanel = new JPanel();

        humanPanel.add(northHumanPanel, BorderLayout.NORTH);
        humanPanel.add(southHumanPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Super Trump Game");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(humanPanel, BorderLayout.SOUTH);

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new BorderLayout());
        frame.add(panelContainer);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        panelContainer.add(centerPanel);

        JLabel welcomeLabel = new JLabel("How many players would you like to play against?");
        centerPanel.add(welcomeLabel);

        TextField numOfPlayers = new TextField();
        numOfPlayers.setColumns(5);
        centerPanel.add(numOfPlayers);

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            centerPanel.remove(centerPanel);
            centerPanel.remove(numOfPlayers);
            centerPanel.remove(welcomeLabel);
            centerPanel.remove(newGameButton);

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

            PlayerView view = new PlayerView(humanPlayer);

            JRadioButton hardness = new JRadioButton("Hardness");
            JRadioButton specificGravity = new JRadioButton("Specific Gravity");
            JRadioButton cleavage = new JRadioButton("Cleavage");
            JRadioButton crustalAbundance = new JRadioButton("Crustal Abundance");
            JRadioButton economicValue = new JRadioButton("Econimic Value");

            ButtonGroup group = new ButtonGroup();
            group.add(hardness);
            group.add(specificGravity);
            group.add(cleavage);
            group.add(crustalAbundance);
            group.add(economicValue);

            southHumanPanel.add(hardness);
            southHumanPanel.add(specificGravity);
            southHumanPanel.add(cleavage);
            southHumanPanel.add(crustalAbundance);
            southHumanPanel.add(economicValue);
            northHumanPanel.add(view);
            frame.repaint();
            frame.revalidate();
        });
        centerPanel.add(newGameButton);
    }
}