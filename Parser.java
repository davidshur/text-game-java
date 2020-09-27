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
   * Primary function which coordinates the parsing procedure.
   * 
   * @param userCommandString User input string to be parsed.
   * @return An array of integers that will be used to determine the method to
   *         run.
   */
  public String[] parse(String userCommandString) {
    String[] cleanedCommand = removeArticles(cleanString(userCommandString));
    return cleanedCommand;
  }

  /**
   * Cleans up and formats the initial command string so that we may parse more
   * easily.
   * 
   * @param s The string that the user has input as a command.
   * @return Array of words without punctuation or capitals.
   */
  private String[] cleanString(String s) {
    String[] a = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    return a;
  }

  /**
   * Remove articles from the command array.
   * 
   * @param words An array of words.
   * @return An array of words without articles.
   */
  private String[] removeArticles(String[] wordArray) {
    ArrayList<String> wordList = new ArrayList<String>();
    for (String word : wordArray) {
      wordList.add(word);
    }

    for (String article : articles) {
      for (String word : wordList) {
        if (word.equals(article)) {
          wordList.remove(word);
        }
      }
    }

    String[] cleanedCommandArray = new String[wordList.size()];
    wordList.toArray(cleanedCommandArray);
    return cleanedCommandArray;
  }
}
