package com.findshur;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.ArrayList;

/**
 * Parser made in the Singleton design pattern.
 */
public final class Parser {
  private static volatile Parser instance;

  private static EnumMap<Subjects, Integer> dictionarySubjects = new EnumMap<>(Subjects.class);

  public Parser() {
    dictionarySubjects.put(Subjects.DUSTYCHEST, 0);
    dictionarySubjects.put(Subjects.DUSTYDOOR, 0);
    dictionarySubjects.put(Subjects.DUSTYCARPET, 0);
    dictionarySubjects.put(Subjects.DUSTYSWORD, 0);
    dictionarySubjects.put(Subjects.GOLDKEY, 0);
    dictionarySubjects.put(Subjects.GOLDLOCK, 0);
    dictionarySubjects.put(Subjects.IRONLOCK, 0);
    dictionarySubjects.put(Subjects.IRONKEY, 0);
    dictionarySubjects.put(Subjects.RUSTYIRONSWORD, 0);
    dictionarySubjects.put(Subjects.LARGEDOOR, 0);
    dictionarySubjects.put(Subjects.LARGEMAN, 0);
    dictionarySubjects.put(Subjects.LARGECHEST, 0);
    dictionarySubjects.put(Subjects.UGLYTROLL, 0);
    dictionarySubjects.put(Subjects.OLDMAN, 0);
    dictionarySubjects.put(Subjects.RUSTYKNIFE, 0);
    dictionarySubjects.put(Subjects.RUSTYLOCK, 0);
    dictionarySubjects.put(Subjects.SKELETONKEY, 0);
    dictionarySubjects.put(Subjects.SCARYDOOR, 0);
  }

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
   * @return An array list of integers that has been cleaned, reduced and
   *         translated to represent a user method.
   */
  public static ArrayList<String> parse(String userInput) {
    var commandArray = cleanStringToArrayList(userInput);

    removeArticles(commandArray);
    createAnyCompoundVerbs(commandArray);
    reduceDictionaryWords(commandArray);

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
   * @param l An array list of strings to have articles removed from.
   */
  private static void removeArticles(ArrayList<String> l) {
    l.removeIf(word -> Words.getArticles().contains(word));
  }

  /**
   * Creates a compound verb by combining the verb with a preposition found next
   * or last in the command array list. Cleans up command array list afterwards.
   * 
   * @param l An array list of strings.
   */
  private static void createAnyCompoundVerbs(ArrayList<String> l) {
    if (l.size() == 1) {
      return;
    }
    var prepositions = Words.getPrepositions().toString();

    if (prepositions.contains(l.get(l.size() - 1))) {
      l.add(1, l.get(l.size() - 1));
      l.remove(l.size() - 1);
    }
    if (prepositions.contains(l.get(1))) {
      l.set(0, l.get(0) + l.get(1));
      l.remove(1);
    }
  }

  /**
   * Reduces words to subjects. Goes from verb to end of sentence or from verb to
   * preposition and from preposition to end of sentence. Reduces words to a
   * single subject string.
   * 
   * @param l An array list of strings in the format [verb, ...words] or [verb,
   *          ...words, preposition, ...words].
   */
  private static void reduceDictionaryWords(ArrayList<String> l) {
    if (l.size() == 1) {
      return;
    }
    int breakPoint = l.size();
    for (String word : l) {
      if (Words.getPrepositions().contains(word)) {
        breakPoint = l.indexOf(word);
      }
    }

    String[] subject1 = { "" };
    String[] subject2 = { "" };
    for (int i = 1; i < breakPoint; i++) {
      subject1[0] += l.get(i);
    }
    if (breakPoint != l.size()) {
      for (int i = breakPoint + 1; i < l.size(); i++) {
        subject2[0] += l.get(i);
      }
    }
    l.removeIf(word -> subject1[0].contains(word) || subject2[0].contains(word));
    l.add(1, subject1[0]);
    if (subject2[0] != "") {
      l.add(3, subject2[0]);
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

    intList[0] = Words.getVerbs().get(stringList.get(0));
    if (stringList.size() > 1) {
      intList[1] = 1;
    }
    if (stringList.size() > 2) {
      intList[2] = 2;
      intList[3] = 3;
    }

    return intList;
  }
}
