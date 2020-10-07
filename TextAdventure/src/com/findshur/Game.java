package com.findshur;

import java.util.Scanner;

public class Game {
  private static Scanner in = new Scanner(System.in);
  private static Player player = new Player();
  private static boolean playing = true;

  public static void main(String[] args) {
    doGameIntro();
    playGame();
    doGameTeardown();
  }

  public static void endGame() {
    playing = false;
  }

  private static void doGameIntro() {
    printStyledText("Welcome to the dungeon. You may say: go, get, or fight.");
  }

  private static void playGame() {
    while (playing) {
      printStyledText(player.getCurrentRoomDescription());
      getAndRunCommand();
    }
  }

  private static void doGameTeardown() {
    in.close();
  }

  private static String getCommand() {
    var command = Parser.parse(in.nextLine());
    System.out.println();
    return command;
  }

  private static void getAndRunCommand() {
    switch (getCommand()) {
      case "GO":
        Player.move();
        break;
      case "GET":
        Player.getItem();
        break;
      case "FIGHT":
        Player.fight();
        break;
      default:
        System.out.println("Valid commands are: go, get, or fight.");
        System.out.println();
    }
  }

  private static void printStyledText(String text) {
    System.out.println("~".repeat(10));
    System.out.println();
    System.out.println(text);
    System.out.println();
  }
}
