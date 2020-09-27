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

  /**
   * Primaary function that initiates the parsing procedure.
   * 
   * @param userCommandString User input string to be parsed.
   * @return An array of integers that will be used to determine the method to
   *         run.
   */
  public String[] parse(String userCommandString) {
    String[] cleanedUserCommand = userCommandString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

    return cleanedUserCommand;
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
