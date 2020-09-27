import java.util.ArrayList;

/**
 * Class that parses user inputs.
 * 
 * @author David Shur
 * @version 0.1 07-27-2020
 */
public class Parser {

  private String[] articles = { "a", "an", "the" };
  private String[] dictionary = { "old", "rusty", "iron", "sword", "box", "key" };
  private String[] prepositions = { "in", "on", "under", "over", "at", "with" };
  private String[] verbs = { "go", "look", "fight", "take", "get", "look at", "examine", "inspect", "pick up", "kill",
      "stab" };

  public ArrayList<String> parse(String userCommandString) {
    String cleanedUserCommand = userCommandString.replaceAll("[^a-zA-Z ]", "").toLowerCase();

    ArrayList<String> userCommandList = stringToList(cleanedUserCommand);
    return userCommandList;
  }

  public ArrayList<String> stringToList(String s) {
    ArrayList<String> l = new ArrayList<String>();
    String[] a = s.split(" ");

    for (String word : a) {
      l.add(word);
    }

    return l;
  }

  /**
   * Returns an array of words without articles.
   * 
   * @param words ArrayList<String>
   * @return String[]
   */
  // private String[] removeArticles(ArrayList<String> words) {
  // for (String article : articles) {
  // for (String word : words) {
  // if (word.equals(article)) {
  // words.remove(word);
  // }
  // }
  // }
  // String[] cleanedCommandArray = new String[words.size()];
  // words.toArray(cleanedCommandArray);
  // return cleanedCommandArray;
  // }
}
