package com.findshur;

import java.util.Arrays;
import java.util.HashSet;

enum actions {
  GO, LOOK, GET, OPEN, FIGHT
};

enum prepositions {
  IN, ON, UNDER, OVER, AT, WITH, UP, OF, BY, FOR, FROM, TO
}

public class Words {
  // create articles hashset
  private static String[] articles = { "A", "AN", "THE" };
  private static HashSet<String> articleHashSet = new HashSet<String>(Arrays.asList(articles));
  // create dictionary hashmap
  private static String[] dictionary = { "DOOR", "MAN", "KEY", "SWORD", "CHEST", "TROLL", "CARPET", "NORTH", "SOUTH",
      "EAST", "WEST", "UP", "DOWN", "SOUTHEAST", "SOUTHWEST", "NORTHEAST", "NORTHWEST", "N", "S", "E", "W", "U", "D",
      "SE", "SW", "NE", "NW", "L" };
  private static HashSet<String> dictionaryHashSet = new HashSet<String>(Arrays.asList(dictionary));
  // create preposition hashset
  private static String[] prepositions = { "IN", "ON", "UNDER", "OVER", "AT", "WITH", "UP", "OF", "BY", "FOR", "FROM",
      "TO" };
  private static HashSet<String> prepositionHashSet = new HashSet<String>(Arrays.asList(prepositions));

  public static HashSet<String> getArticles() {
    return articleHashSet;
  }

  public static HashSet<String> getDictionary() {
    return dictionaryHashSet;
  }

  public static HashSet<String> getPrepositions() {
    return prepositionHashSet;
  }
}
