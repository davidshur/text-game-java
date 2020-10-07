package com.findshur;

import java.util.ArrayList;

/**
 * Player made in the Singleton design pattern.
 */
public final class Player {
  private static boolean isArmed = false;
  private static Room currentRoom;
  private static ArrayList<Item> inventory = new ArrayList<>();

  public Player() {
    var location = new Location();
    currentRoom = location.firstRoom;
  }

  public static boolean isArmed() {
    return isArmed;
  }

  public static void setArmed(boolean armed) {
    isArmed = armed;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public String getCurrentRoomDescription() {
    return getCurrentRoom().getDescription();
  }

  public static void move() {
    currentRoom = Location.getNextRoom(currentRoom);
  }

  public static void getItem() {
    var newItem = currentRoom.getItem();
    if (newItem != null) {
      if (newItem.isWeapon()) {
        setArmed(true);
      }
      inventory.add(newItem);
      System.out.println("You picked up a " + newItem.getName() + "!");
      System.out.println();
    } else {
      System.out.println("There is nothing to get here.");
      System.out.println();
    }
  }

  public static void fight() {
    if (currentRoom.getRoom() == Rooms.TROLL) {
      if (isArmed()) {
        System.out.println("You killed the troll and lived happily ever after. You win!");
        System.out.println();
        Game.endGame();
      } else {
        System.out.println(
            "The troll destroys you with one fell swoop. If only you had something to defend yourself with. You lose...");
        System.out.println();
        Game.endGame();
      }
    } else {
      System.out.println("There is nothing to fight here.");
      System.out.println();
    }
  }
}
