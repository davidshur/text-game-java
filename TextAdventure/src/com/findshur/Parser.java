package com.findshur;

import com.findshur.Enums.Articles;
import com.findshur.Enums.Prepositions;
import com.findshur.Enums.Dictionary;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * Parser made in the Singleton design pattern.
 */
public final class Parser {
  // create hashset of articles
  private static EnumSet<Articles> articles = EnumSet.allOf(Articles.class);
  private static HashSet<Articles> articlesHashSet = new HashSet<Articles>(articles);
  // create hashset of prepositions
  private static EnumSet<Prepositions> prepositions = EnumSet.allOf(Prepositions.class);
  private static HashSet<Prepositions> prepositionsHashSet = new HashSet<Prepositions>(prepositions);
  // create hashset of dictionary
  private static EnumSet<Dictionary> dictionary = EnumSet.allOf(Dictionary.class);
  private static HashSet<Dictionary> dictionaryHashSet = new HashSet<Dictionary>(dictionary);

  private static volatile Parser instance;

  /**
   * Creates an instance of the Parser ensures Singleton pattern even in
   * multi-threading situation.
   * 
   * @return the Parser instance.
   */
  public static Parser getInstance() {
    Parser result = instance;
    if (result != null) {
      return result;
    }
    synchronized (Parser.class) {
      if (instance == null) {
        instance = new Parser();
      }
      return instance;
    }
  }

  /**
   * Takes a user command string and parses it to a user command array.
   * 
   * @param userInput String user has entered as a command.
   * @return ArrayList<Integer> that has been cleaned, reduced and translated to
   *         represent a user method.
   */
  public static ArrayList<String> parse(String userInput) {
    var commandArray = cleanStringToArrayList(userInput);

    removeArticles(commandArray);
    createAnyCompoundVerb(commandArray);

    return commandArray;
  }

  /**
   * Cleans, formats, and splits a string to an array list.
   * 
   * @param s A string.
   * @return Array list that has been cleaned and split to words containing only
   *         upper-case letters and no symbols.
   */
  private static ArrayList<String> cleanStringToArrayList(String s) {
    var a = s.replaceAll("[^a-zA-Z ]", "").toUpperCase().split("\\s+");
    var l = new ArrayList<String>(Arrays.asList(a));
    return l;
  }

  /**
   * Takes an array list of strings and removes articles... "a", "an", "the".
   * 
   * @param l ArrayList<String> to have articles removed from.
   */
  private static void removeArticles(ArrayList<String> l) {
    l.removeIf(word -> articlesHashSet.toString().contains(word));
  }

  /**
   * Creates a compound verb by combining the verb with a preposition found next
   * or last in the command array list. Cleans up command array list afterwards.
   * 
   * @param l An ArrayList of strings.
   * @return An ArrayList of strings with a compound verb instead of a verb and
   *         separate preposition, if possible.
   */
  private static void createAnyCompoundVerb(ArrayList<String> l) {
    if (prepositionsHashSet.toString().contains(l.get(l.size() - 1))) {
      l.add(1, l.get(l.size() - 1));
      l.remove(l.size() - 1);
    }
    if (prepositionsHashSet.toString().contains(l.get(1))) {
      l.set(0, l.get(0) + l.get(1));
      l.remove(1);
    }
  }

  /**
   * Takes an array list of words and maps it to an array list of integers.
   * 
   * @param wordList An array list of strings in the format [verb, dictionary] or
   *                 [verb, dictionary, preposition, dictionary] where dictionary
   *                 can be more than one word representing a game object (i.e.
   *                 ugly cave troll).
   * @return An array of integers which will have a length of either 2 or 4
   *         depending on if a preposition was used mid sentence.
   */
  private static int[] mapStringsToIntegers(ArrayList<String> stringList) {
    int[] intList = new int[4];

    return intList;
  }
}
