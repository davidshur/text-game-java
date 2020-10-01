package com.findshur;

import java.util.Scanner;

public class Game {
  private static boolean playing = true;
  private static String introText = "You open your eyes and see that you are near a smoldering fire.";
  private static String endingText = "Someone's life flashes before your eyes. Guess this is the end.";
  private static String roomText = "There is a cave opening to the North. On the floor you see a scattering of papers. You are surrounded by a redwood forest on all other sides.";

  public static void main(String[] args) {
    Parser.getInstance();
    var in = new Scanner(System.in);
    printGameText(introText);

    while (playing) {
      printGameText(roomText);
      var input = in.nextLine();
      if (input.equals("stop")) {
        parseAndPrintUserText("Stop game.");
        break;
      }
      parseAndPrintUserText(input);
    }

    in.close();
    printGameText(endingText);
  }

  /**
   * Prints styled game text and descriptions.
   * 
   * @param text A string to be printed stylistically.
   */
  private static void printGameText(String text) {
    System.out.println("~".repeat(10));
    System.out.println();
    System.out.println(text);
    System.out.println();
  }

  /**
   * Prints parsed user command for debugging.
   * 
   * @param s User input string from the scanner.
   */
  private static void parseAndPrintUserText(String s) {
    var command = Parser.parse(s);

    System.out.println();
    System.out.println("Parsed command:");
    System.out.println(command);
    System.out.println();
  }
}
