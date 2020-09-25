import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean running = true;
    // System objects
    Random rand = new Random();
    Scanner in = new Scanner(System.in);

    // Introduction
    System.out.println("Hello!! Welcome to Adventure.");
    System.out.println("Would you like instructions?");
    String input = in.nextLine();
    if (input.equals("yes")) {
      System.out.println("These are the instructions of the game. Have fun!");
    } else if (input.equals("no")) {
      System.out.println("Let's get started then.");
    } else {
      System.out.println("Not quite sure what you meant... we are going to press on.");
    }

    // Game running
    while (running) {
      System.out.println("Are you having fun?");
      String response = in.nextLine();
      if (response.equals("yes")) {
        System.out.println("Then let's keep going!");
      } else  if (response.equals("no")) {
        System.out.println("Let's stop then.");
        running = false;
      } else {
        System.out.println("Please say yes or no.");
      }
    }
  }
}