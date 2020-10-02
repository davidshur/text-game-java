package com.findshur;

enum Rooms {
  ENTRANCE, CHEST, TROLL
}

public class Room {
  private static Enum<?> room;
  private static Enum<?> nextRoom;
  private static String name;
  private static String description;

  public Room(Enum<?> aRoom, Enum<?> theNextRoom, String aName, String aDescription) {
    room = aRoom;
    nextRoom = theNextRoom;
    name = aName;
    description = aDescription;
  }

  public static String getName() {
    return name;
  }

  public static String getDescription() {
    return description;
  }

  public static Enum<?> getRoom() {
    return room;
  }

  public static Enum<?> getNextRoom() {
    return nextRoom;
  }
}
