import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is a text-parser adventure modeled after the great Infocom text
 * adventures of the 90s.
 * 
 * @version 0.03 09--27-2020
 * @author David Shur
 */

public class Game {
  public static boolean playing = true;
  public static int currentRoom = 0;
  public static int[] goNorth = { 0, 8 };

  public static HashMap<Integer, Room> roomHashMap = new HashMap<Integer, Room>();

  public static void main(String[] args) {
    Parser textParser = new Parser();
    Scanner in = new Scanner(System.in);

    Room opening = new Room(1, -1, 2, -1, "Cave Entrance",
        "You find yourself in a narrow cave entry way. The winding path forks here, there is a wide passage to the North and a crawlway to the East.");
    roomHashMap.put(0, opening);

    Room trollRoom = new Room(-1, 0, 3, -1, "Troll Room",
        "The room you stand in is dominated by a hulking troll who is angry, with snot dangling from his nose. There are exits to the South and East.");
    roomHashMap.put(1, trollRoom);

    intro();

    // Playing game
    while (playing) {
      Room room = roomHashMap.get(currentRoom);

      System.out.println();
      System.out.println(room.getDescription());
      System.out.println();
      System.out.println();

      String input = in.nextLine();

      int[] command = textParser.parse(input);

      if (Arrays.equals(command, goNorth)) {
        currentRoom = room.goNorth();
      }
    }

    in.close();
  }

  /**
   * Prints the introduction.
   */
  public static void intro() {
    System.out.println("-".repeat(30));
    System.out.println("Welcome to the cave!");
    System.out.println("-".repeat(30));
  }

  /**
   * Prints the text to be shown when the game is won.
   */
  public static void win() {
    System.out.println("-".repeat(30));
    System.out.println("You collect the troll's treasure and emerge victorious! You win!");
    System.out.println("-".repeat(30));
    playing = false;
  }

  /**
   * Prints the text to be shown when the game is lost.
   */
  public static void lose() {
    System.out.println("-".repeat(30));
    System.out.println("You died! Please do try again.");
    System.out.println("-".repeat(30));
    playing = false;
  }
}