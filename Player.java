import java.util.ArrayList;

public class Player {
  private int health = 100;
  private int score = 0;
  private int currentRoom = 0;
  ArrayList<Integer> inventory = new ArrayList<Integer>();

  public int getScore() {
    return score;
  }

  public void increaseScore(int points) {
    score += points;
  }

  public int getHealth() {
    return health;
  }

  public void reduceHealth(int damage) {
    health -= damage;
  }

  public int getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(int newRoomNumber) {
    currentRoom = newRoomNumber;
    getCurrentRoom();
  }
}
