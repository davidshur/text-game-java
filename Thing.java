public class Thing {
  // fields
  private int itemId;
  private String itemName;
  private String itemDescription;
  private boolean itemIsHolder;

  // constructor
  public Thing(int id, String name, String description, boolean isHolder) {
    itemId = id;
    itemName = name;
    itemDescription = description;
    itemIsHolder = isHolder;
  }

  // methods
  public int getId() {
    return itemId;
  }

  public String getName() {
    return itemName;
  }

  public String getDescription() {
    return itemDescription;
  }

  public boolean getIsHolder() {
    return itemIsHolder;
  }
}
