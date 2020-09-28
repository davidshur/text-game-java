import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Class that parses user inputs.
 * 
 * @author David Shur
 * @version 0.2 07-27-2020
 */
public class Parser {

  private String[] articles = { "a", "an", "the" };
  private String[] dictionary = { "old", "rusty", "iron", "sword", "box", "key" };
  private String[] prepositions = { "in", "on", "under", "over", "at", "with", "up" };
  private String[] verbs = { "go", "look", "fight", "take", "get", "look at", "look around", "examine", "inspect",
      "pick up", "kill", "stab" };
  HashSet<String> articleHashSet = new HashSet<String>();
  HashSet<String> prepositionHashSet = new HashSet<String>();
  HashMap<String, Integer> verbHashMap = new HashMap<String, Integer>();

  /**
   * Primary function which coordinates the parsing procedure.
   * 
   * @param userCommandString User input string to be parsed.
   * @return An array of integers that will be used to determine the method to
   *         run.
   */
  public String[] parse(String userCommandString) {
    // Make articles HashSet
    for (String article : articles) {
      articleHashSet.add(article);
    }

    // Make prepositions HashSet
    for (String preposition : prepositions) {
      prepositionHashSet.add(preposition);
    }

    // Make verbs HashMap
    verbHashMap.put("go", 0);
    verbHashMap.put("move", 0);
    verbHashMap.put("look", 1);
    verbHashMap.put("look around", 1);
    verbHashMap.put("look at", 2);
    verbHashMap.put("examine", 2);
    verbHashMap.put("inspect", 2);
    verbHashMap.put("view", 2);
    verbHashMap.put("take", 3);
    verbHashMap.put("get", 3);
    verbHashMap.put("pick up", 3);
    verbHashMap.put("fight", 4);
    verbHashMap.put("kill", 4);
    verbHashMap.put("stab", 4);
    verbHashMap.put("destroy", 4);

    // Run logic
    String[] cleanedCommand = cleanString(userCommandString);

    ArrayList<String> userCommandList = new ArrayList<String>();
    for (String word : cleanedCommand) {
      userCommandList.add(word);
    }

    ArrayList<String> noArticlesList = removeArticles(userCommandList);
    ArrayList<String> reducedCommandList = reducePrepositionsToVerb(noArticlesList);
    String[] parsedCommandArray = new String[reducedCommandList.size()];
    reducedCommandList.toArray(parsedCommandArray);
    return parsedCommandArray;
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
   * Removes articles from the command list.
   * 
   * @param words An ArrayList of words.
   * @return An ArrayList of words without articles.
   */
  private ArrayList<String> removeArticles(ArrayList<String> wordList) {
    wordList.removeIf(word -> articleHashSet.contains(word));
    return wordList;
  }

  /**
   * Joins preposition to make a compound verb from the command list, if possible.
   * 
   * @param words An ArrayList of words.
   * @return An ArrayList of words with compound verbs instead of a separate
   *         preposition.
   */
  private ArrayList<String> reducePrepositionsToVerb(ArrayList<String> wordList) {
    for (String word : wordList) {
      if (prepositionHashSet.contains(word)) {
        wordList.set(0, wordList.get(0) + " " + word);
      }
    }
    wordList.removeIf(word -> prepositionHashSet.contains(word));
    return wordList;
  }
}
