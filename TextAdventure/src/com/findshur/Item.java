package com.findshur;

public class Item {
  private String name;
  private boolean isWeapon;

  public Item(String aName, boolean isAWeapon) {
    name = aName;
    isWeapon = isAWeapon;
  }

  /**
   * Tells you if the item is a weapon or not.
   * 
   * @return Gives back true if the item is a weapon and false if it is not.
   */
  public boolean isWeapon() {
    return isWeapon;
  }

  public String getName() {
    return name;
  }
}
