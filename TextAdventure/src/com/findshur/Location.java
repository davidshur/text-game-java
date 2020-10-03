package com.findshur;

import java.util.HashMap;

/**
 * Simple map for the adventure. Makes room objects. Has a function to return
 * the next room, given a room object.
 */
public class Location {
  public Room firstRoom;
  private static HashMap<Room, Room> map = new HashMap<Room, Room>();

  public Location() {
    var entranceRoom = new Room(Rooms.ENTRANCE, Rooms.CHEST, "Cave Entrance",
        "You are standing outside a cave. The breeze is cold and biting. Ahead of you is the only shelter for miles. It looks like there is only one way to go.",
        null);
    var chestRoom = new Room(Rooms.CHEST, Rooms.TROLL, "Cavern",
        "It is damp inside. It smells of death. Behind a pile of rocks, there is a large iron sword covered in cobwebs. The only way forward is ahead through a small and narrow crawlway.",
        new Item("Dusty Sword", true));
    var trollRoom = new Room(Rooms.TROLL, Rooms.CHEST, "Troll Room",
        "A large and vicious troll stands before you. It sneers and bangs on its chest. Snot drips from its nose.",
        null);

    firstRoom = entranceRoom;

    map.put(entranceRoom, chestRoom);
    map.put(chestRoom, trollRoom);
    map.put(trollRoom, chestRoom);
  }

  /**
   * Gets the next room using the current room.
   * 
   * @param room A given room, most likely the current room of the player.
   * @return The room object of the next room.
   */
  public static Room getNextRoom(Room room) {
    var nextRoom = map.get(room);
    return nextRoom;
  }
}
