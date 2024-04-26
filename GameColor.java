import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

abstract class access{
    abstract void play();
    public void accesses(){
        System.out.println("If you don't have matching card press Enter!");
    }
}
public class Game extends access{

    public void play(){
        System.out.println("Welcome to the game");
    }

    public static void main(String[] args) {
        // Create a new instance of the Game class
        Game g=new Game();
        g.play();
        g.accesses();
        Game game = new Game();
        // Start the game
        game.start();
    }

    public void start() {
        // Define the colors
        String[] colors = {"Red", "Blue", "White", "Black", "Red", "Blue", "White", "Red", "Blue", "White"};

        // Shuffle the colors
        List<String> colorList = Arrays.asList(colors);
        Collections.shuffle(colorList);

        // Deal the colors between players
        List<String> player1Hand = new ArrayList<>(colorList.subList(0, colorList.size() / 3));
        List<String> player2Hand = new ArrayList<>(colorList.subList(colorList.size() / 3,2*colorList.size() / 3));
        List<String> player3Hand = new ArrayList<>(colorList.subList(2 * colorList.size() / 3, colorList.size()-1));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print players' hands
            System.out.println("Player 1's hand:");
            for (String color : player1Hand) {
                System.out.println(color);
            }
            System.out.println("Player 2's hand:");
            for (String color : player2Hand) {
                System.out.println(color);
            }
            System.out.println("Player 3's hand:");
            for (String color : player3Hand) {
                System.out.println(color);

            }
            System.out.println("\n");

            // Player 1's turn
            System.out.println("Player 1, enter the color card you want to put:");
            String player1Choice = scanner.nextLine();
            if (player1Choice.equalsIgnoreCase("Black")) {
                System.out.println("Player 1 lost! Player 1 put Black card.");
                break;
            } else {
                if (player1Hand.remove(player1Choice)) {
                    System.out.println("Player 1 put " + player1Choice + ".");
                } else {
                    System.out.println("Player 1 doesn't have" + player1Choice + " in their hand.");
                }
            }

            // Player 2's turn
            System.out.println("Player 2, enter the color card you want to put:");
            String player2Choice = scanner.nextLine();
            if (player2Choice.equalsIgnoreCase("Black")) {
                System.out.println("Player 2 lost! Player 2 put Black card.");
                break;
            } else {
                if (player2Hand.remove(player2Choice)) {
                    System.out.println("Player 2 put " + player2Choice + ".");
                } else {
                    System.out.println("Player 2 doesn't have" + player2Choice + " in their hand.");
                }
            }

            // Player 3's turn
            System.out.println("Player 3, enter the color card you want to put:");
            String player3Choice = scanner.nextLine();
            if (player3Choice.equalsIgnoreCase("Black")) {
                System.out.println("Player 3 lost! Player 3 put Black card.");
                break;
            } else {
                if (player3Hand.remove(player3Choice)) {
                    System.out.println("Player 3 put " + player3Choice + ".");
                } else {
                    System.out.println("Player 3 doesn't have " + player3Choice + " in their hand.");
                }
            }
        }
        scanner.close();

        // Determine the winner
        if (containsBlack(player1Hand)) {
            System.out.println("Player 1 lost!");
        } else if (containsBlack(player2Hand)) {
            System.out.println("Player 2 lost!");
        } else if (containsBlack(player3Hand)) {
            System.out.println("Player 3 lost!");
        }
    }

    private boolean containsBlack(List<String> hand) {
        return hand.contains("Black");
    }
}