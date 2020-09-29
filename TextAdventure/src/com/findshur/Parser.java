package com.findshur;

import com.findshur.Enums.Articles;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * Parser made in the Singleton design pattern. This singleton is safe for use
 * in multithreaded environments due to the synchronizing of the threads.
 */
public final class Parser {
  private static volatile Parser instance;

  private EnumSet<Articles> articles = EnumSet.allOf(Articles.class);
  private HashSet<Articles> articlesHashSet = new HashSet<Articles>(articles);

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
  public ArrayList<String> parse(String userInput) {
    var commandArray = cleanStringToArrayList(userInput);
    removeArticles(commandArray);
    return commandArray;
  }

  /**
   * Takes user command and then cleans, formats, and splits it to an array list
   * from where it can be used in the parsing process.
   * 
   * @param s User command as string.
   * @return ArrayList<String> of user command that has been cleaned and split to
   *         words containing only upper-case letters and no symbols.
   */
  private ArrayList<String> cleanStringToArrayList(String s) {
    var a = s.replaceAll("[^a-zA-Z ]", "").toUpperCase().split("\\s+");
    var l = new ArrayList<String>(Arrays.asList(a));
    return l;
  }

  /**
   * Takes an array list of strings and removes articles... "a", "an", "the".
   * 
   * @param l ArrayList<String> to have articles removed from.
   */
  private void removeArticles(ArrayList<String> l) {
    l.removeIf(word -> articlesHashSet.toString().contains(word));
  }
}
