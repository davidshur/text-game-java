
/**
 * This is a text-parser adventure modeled after the great Infocom text
 * adventures of the 90s.
 * 
 * @version 0.02 09--26-2020
 * @author David Shur
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

  public static void main(String[] args) {
    intro();
    Scanner in = new Scanner(System.in);
    Parser textParser = new Parser();
    String input = in.nextLine();

    ArrayList<String> command = textParser.parse(input);
    System.out.println(command);
    in.close();
  }

  public static void intro() {
    System.out.println("-".repeat(10));
    System.out.println("Welcome to the parser!");
    System.out.println("You should type something into the terminal.");
    System.out.println("If all goes well, upon hitting enter you should receive back an array with numbers.");
    System.out.println("This array represents the meaning of your command.");
    System.out.println("-".repeat(10));
  }
}