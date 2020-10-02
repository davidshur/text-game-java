package com.findshur;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

enum actions {
  GO, LOOK, GET, OPEN, FIGHT
};

enum prepositions {
  IN, ON, UNDER, OVER, AT, WITH, UP, OF, BY, FOR, FROM, TO
}

enum subjects {
  DUSTYCHEST, DUSTYDOOR, DUSTYCARPET, DUSTYSWORD, GOLDKEY, GOLDLOCK, IRONLOCK, IRONKEY, RUSTYIRONSWORD, LARGEDOOR,
  LARGEMAN, LARGECHEST, UGLYTROLL, OLDMAN, RUSTYKNIFE, RUSTYLOCK, SKELETONKEY, SCARYDOOR
}

public class Words {
  // create articles hashset
  private static String[] articles = { "A", "AN", "THE" };
  private static HashSet<String> articleHashSet = new HashSet<String>(Arrays.asList(articles));
  // create dictionary hashmap
  private static String[] dictionary = { "DOOR", "LARGE", "DUSTY", "KNIFE", "OLD", "IRON", "ELVISH", "SCARY", "RUSTY",
      "SKELETON", "GOLD", "MAN", "KEY", "SWORD", "CHEST", "TROLL", "CARPET", "NORTH", "SOUTH", "EAST", "WEST", "UP",
      "DOWN", "SOUTHEAST", "SOUTHWEST", "NORTHEAST", "NORTHWEST", "UGLY", "N", "S", "E", "W", "U", "D", "SE", "SW",
      "NE", "NW", "L" };
  private static HashMap<String, Enum<?>[]> dictionaryHashMap = new HashMap<String, Enum<?>[]>();
  // create preposition hashset
  private static String[] prepositions = { "IN", "ON", "UNDER", "OVER", "AT", "WITH", "UP", "OF", "BY", "FOR", "FROM",
      "TO" };
  private static HashSet<String> prepositionHashSet = new HashSet<String>(Arrays.asList(prepositions));

  public Words() {
    dictionaryHashMap.put("DUSTY",
        new Enum<?>[] { subjects.DUSTYCARPET, subjects.DUSTYCHEST, subjects.DUSTYDOOR, subjects.DUSTYSWORD });
    dictionaryHashMap.put("GOLD", new Enum<?>[] { subjects.GOLDKEY, subjects.GOLDLOCK });
    dictionaryHashMap.put("IRON", new Enum<?>[] { subjects.IRONKEY, subjects.RUSTYIRONSWORD, subjects.IRONLOCK });
    dictionaryHashMap.put("LARGE", new Enum<?>[] { subjects.LARGECHEST, subjects.LARGEDOOR, subjects.LARGEMAN });
    dictionaryHashMap.put("OLD", new Enum<?>[] { subjects.OLDMAN });
    dictionaryHashMap.put("RUSTY", new Enum<?>[] { subjects.RUSTYKNIFE, subjects.RUSTYLOCK });
    dictionaryHashMap.put("SKELETON", new Enum<?>[] { subjects.SKELETONKEY });
    dictionaryHashMap.put("SCARY", new Enum<?>[] { subjects.SCARYDOOR });
    dictionaryHashMap.put("CHEST", new Enum<?>[] { subjects.DUSTYCHEST, subjects.LARGECHEST });
    dictionaryHashMap.put("DOOR", new Enum<?>[] { subjects.DUSTYDOOR, subjects.LARGEDOOR, subjects.SCARYDOOR });
    dictionaryHashMap.put("CARPET", new Enum<?>[] { subjects.DUSTYCARPET });
    dictionaryHashMap.put("SWORD", new Enum<?>[] { subjects.DUSTYSWORD, subjects.RUSTYIRONSWORD });
    dictionaryHashMap.put("KEY", new Enum<?>[] { subjects.GOLDKEY, subjects.IRONKEY, subjects.SKELETONKEY });
    dictionaryHashMap.put("LOCK", new Enum<?>[] { subjects.GOLDLOCK, subjects.IRONLOCK, subjects.RUSTYLOCK });
    dictionaryHashMap.put("KNIFE", new Enum<?>[] { subjects.RUSTYKNIFE });
    dictionaryHashMap.put("TROLL", new Enum<?>[] { subjects.UGLYTROLL });
    dictionaryHashMap.put("MAN", new Enum<?>[] { subjects.LARGEMAN, subjects.OLDMAN });
  }

  public static HashSet<String> getArticles() {
    return articleHashSet;
  }

  public static HashMap<String, Enum<?>[]> getDictionary() {
    return dictionaryHashMap;
  }

  public static HashSet<String> getPrepositions() {
    return prepositionHashSet;
  }
}
