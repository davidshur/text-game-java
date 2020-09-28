public class Room extends Instance {
  int north;
  int south;
  int east;
  int west;
  int[] contains;

  public Room(int n, int s, int e, int w, String name, String desc, boolean cont, boolean visi, int[] i) {
    super(name, desc, cont, visi);
    north = n;
    south = s;
    east = e;
    west = w;
    contains = i;
  }
}