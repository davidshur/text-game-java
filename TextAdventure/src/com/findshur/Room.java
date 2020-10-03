package com.findshur;

enum Rooms {
  ENTRANCE, CHEST, TROLL
}

public class Room {
  private Enum<?> room;
  private Enum<?> nextRoom;
  private String name;
  private String description;
  private Item item;

  public Room(Enum<?> aRoom, Enum<?> theNextRoom, String aName, String aDescription, Item anItem) {
    room = aRoom;
    nextRoom = theNextRoom;
    name = aName;
    description = aDescription;
    item = anItem;
  }

  public Enum<?> getRoom() {
    return room;
  }

  public Enum<?> getNextRoom() {
    return nextRoom;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Item getItem() {
    return item;
  }
}
