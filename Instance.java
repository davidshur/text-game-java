public abstract class Instance {
  private static int nextId = 0;

  private int id;
  private String name;
  private String description;
  private boolean isContainer;
  private boolean isVisible;

  public Instance(String n, String d, boolean c, boolean v) {
    name = n;
    description = d;
    isContainer = c;
    isVisible = v;

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

  public boolean getIsContainer() {
    return isContainer;
  }

  public boolean getIsVisible() {
    return isVisible;
  }
}