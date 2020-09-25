import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // System objects
    Random rand = new Random();
    Scanner in = new Scanner(System.in);

    // Introduction
    System.out.println("Hello!! Welcome to Adventure.");
    System.out.println("Would you like instructions?");
    String input = in.nextLine();
    if (input.equals("yes")) {
      System.out.println("These are the instructions of the game. Have fun!");
    } else {
      System.out.println("Let's get started then.");
    }
  }
}