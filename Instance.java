public abstract class Instance {
  private static int nextId = 0;

  private int id;
  private String name;
  private String description;

  public Instance(String n, String d) {
    name = n;
    description = d;

    id = nextId++;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}