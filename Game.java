/**
 * This is a text-parser adventure modeled after the great Infocom text
 * adventures of the 90s.
 * 
 * @version 0.0.1
 * @author David Shur
 */
public class Game {

  public static void main(String[] args) {
    intro();
  }

  public static void intro() {
    System.out.println("-".repeat(10));
    System.out.println("Welcome to the game!");
    System.out.println("-".repeat(10));
  }
}