package com.findshur;

import java.util.HashMap;

public class Map {
  private static HashMap<Room, Room> map = new HashMap<Room, Room>();

  public Map() {
    var entranceRoom = new Room(Rooms.ENTRANCE, Rooms.CHEST, "Cave Entrance",
        "You are standing outside a cave. The breeze is cold and biting. Ahead of you is the only shelter for miles. It looks like there is only one way to go.");
    var chestRoom = new Room(Rooms.CHEST, Rooms.TROLL, "Cavern",
        "It is damp inside. It smells of death. Behind a pile of rocks, there is a large iron sword covered in cobwebs. The only way forward is ahead through a small and narrow crawlway.");
    var trollRoom = new Room(Rooms.TROLL, Rooms.CHEST, "Troll Room",
        "A large and vicious troll stands before you. It sneers and bangs on its chest. Snot drips from its nose.");

    map.put(entranceRoom, chestRoom);
    map.put(chestRoom, trollRoom);
    map.put(trollRoom, chestRoom);
  }

  public static Room nextRoom(Room room) {
    var nextRoom = map.get(room);
    return nextRoom;
  }
}
