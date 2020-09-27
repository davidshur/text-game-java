import java.util.ArrayList;

public class Parser {

  private String[] articles = { "a", "an", "the" };
  private String[] dictionary = { "old", "rusty", "iron", "sword", "box", "key" };
  private String[] prepositions = { "in", "on", "under", "over", "at", "with" };
  private String[] verbs = { "go", "look", "fight", "take", "get", "look at", "examine", "inspect", "pick up", "kill",
      "stab" };

  public ArrayList<String> parse(ArrayList<String> words) {
    for (String article : articles) {
      for (String word : words) {
        if (word.equals(article)) {
          words.remove(word);
        }
      }
    }
    return words;
  }
}
