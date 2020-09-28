public class Room extends Instance {
  private int north;
  private int south;
  private int east;
  private int west;

  public Room(int n, int s, int e, int w, String name, String desc) {
    super(name, desc);
    north = n;
    south = s;
    east = e;
    west = w;
  }

  public int goNorth() {
    return north;
  }

  public int goSouth() {
    return south;
  }

  public int goEast() {
    return east;
  }

  public int goWest() {
    return west;
  }
}