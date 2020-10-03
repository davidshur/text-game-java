package com.findshur;

import java.util.Scanner;

public class Game {
  private static boolean playing = true;
  private static String introduction = "Welcome to the dungeon. You may say: go, get, or fight.";

  public static void main(String[] args) {
    var in = new Scanner(System.in);
    var player = Player.getInstance();

    printGameText(introduction);
    while (playing) {
      printGameText(player.getCurrentRoom().getDescription());
      var input = in.nextLine();
      var command = Parser.parse(input);
      System.out.println();
      switch (command) {
        case "GO":
          Player.move();
          break;
        case "GET":
          Player.get();
          break;
        case "FIGHT":
          Player.attack();
          break;
        default:
          System.out.println("Valid commands are: go, get, or fight.");
          System.out.println();
      }
    }

    in.close();
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

  public static void endGame() {
    playing = false;
  }
}
