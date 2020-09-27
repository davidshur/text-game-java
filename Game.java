
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
    ArrayList<String> words = new ArrayList<String>();

    String[] a = input.split(" ");
    for (int i = 0; i < a.length; i++) {
      words.add(a[i]);
    }

    ArrayList<String> wordsNoArticles = textParser.parse(words);
    System.out.println(wordsNoArticles);
    in.close();
  }

  public static void intro() {
    System.out.println("-".repeat(10));
    System.out.println("Welcome to the game!");
    System.out.println("-".repeat(10));
  }
}