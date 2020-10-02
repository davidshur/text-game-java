package com.findshur;

import java.util.Scanner;

public class Game {
  private static boolean playing = true;
  private static String introduction = "Welcome to the dungeon. You may say: go, get, or attack.";

  public static void main(String[] args) {
    var in = new Scanner(System.in);
    var player = Player.getInstance();

    printGameText(introduction);
    while (playing) {
      printGameText();
      var input = in.nextLine();
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
}
