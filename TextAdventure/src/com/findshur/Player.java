package com.findshur;

/**
 * Player made in the Singleton design pattern.
 */
public final class Player {
  private static volatile Player instance;

  private static boolean isArmed = false;

  /**
   * Creates an instance of the Player ensures Singleton pattern even in
   * multi-threading situation.
   * 
   * @return the Player instance.
   */
  public static Player getInstance() {
    Player result = instance;
    if (result != null) {
      return result;
    }
    synchronized (Player.class) {
      if (instance == null) {
        instance = new Player();
      }
      return instance;
    }
  }

  /**
   * Gets whether player is carrying a weapon.
   * 
   * @return boolean describing if the player is armed.
   */
  public static boolean isArmed() {
    return isArmed;
  }

  /**
   * Sets whether player is carrying a weapon.
   * 
   * @param armed boolean to set armed status to.
   */
  public static void setArmed(boolean armed) {
    isArmed = armed;
  }
}
