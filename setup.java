/**
 * Created by Jack on 31/08/2016.
 */
import java.util.Scanner;
public class setup {

    public void main(String[] args) {
        introductionMessage();
        //System.out.println(introductionMessage());
    }

    private static int introductionMessage() {
        Scanner userMenuInput = new Scanner(System.in);
        System.out.println("Welcome to the mineral game");
        System.out.println("1. Start game");
        System.out.println("2. exit");
        int userInput = Integer.parseInt(userMenuInput.next());
        return userInput;
    }

    private static void startNewGame() {
        int numberOfPlayers = 1; //todo get number of players;
        STGame game = new STGame(numberOfPlayers);
        game.selectDealer();
    }



}
