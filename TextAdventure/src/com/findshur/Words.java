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

enum Subjects {
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
      "TO", "AROUND" };
  private static HashSet<String> prepositionHashSet = new HashSet<String>(Arrays.asList(prepositions));
  // create verb hashmap
  private static HashMap<String, Integer> verbHashMap = new HashMap<String, Integer>();

  public Words() {
    dictionaryHashMap.put("DUSTY",
        new Enum<?>[] { Subjects.DUSTYCARPET, Subjects.DUSTYCHEST, Subjects.DUSTYDOOR, Subjects.DUSTYSWORD });
    dictionaryHashMap.put("GOLD", new Enum<?>[] { Subjects.GOLDKEY, Subjects.GOLDLOCK });
    dictionaryHashMap.put("IRON", new Enum<?>[] { Subjects.IRONKEY, Subjects.RUSTYIRONSWORD, Subjects.IRONLOCK });
    dictionaryHashMap.put("LARGE", new Enum<?>[] { Subjects.LARGECHEST, Subjects.LARGEDOOR, Subjects.LARGEMAN });
    dictionaryHashMap.put("OLD", new Enum<?>[] { Subjects.OLDMAN });
    dictionaryHashMap.put("RUSTY", new Enum<?>[] { Subjects.RUSTYKNIFE, Subjects.RUSTYLOCK });
    dictionaryHashMap.put("SKELETON", new Enum<?>[] { Subjects.SKELETONKEY });
    dictionaryHashMap.put("SCARY", new Enum<?>[] { Subjects.SCARYDOOR });
    dictionaryHashMap.put("CHEST", new Enum<?>[] { Subjects.DUSTYCHEST, Subjects.LARGECHEST });
    dictionaryHashMap.put("DOOR", new Enum<?>[] { Subjects.DUSTYDOOR, Subjects.LARGEDOOR, Subjects.SCARYDOOR });
    dictionaryHashMap.put("CARPET", new Enum<?>[] { Subjects.DUSTYCARPET });
    dictionaryHashMap.put("SWORD", new Enum<?>[] { Subjects.DUSTYSWORD, Subjects.RUSTYIRONSWORD });
    dictionaryHashMap.put("KEY", new Enum<?>[] { Subjects.GOLDKEY, Subjects.IRONKEY, Subjects.SKELETONKEY });
    dictionaryHashMap.put("LOCK", new Enum<?>[] { Subjects.GOLDLOCK, Subjects.IRONLOCK, Subjects.RUSTYLOCK });
    dictionaryHashMap.put("KNIFE", new Enum<?>[] { Subjects.RUSTYKNIFE });
    dictionaryHashMap.put("TROLL", new Enum<?>[] { Subjects.UGLYTROLL });
    dictionaryHashMap.put("MAN", new Enum<?>[] { Subjects.LARGEMAN, Subjects.OLDMAN });

    verbHashMap.put("GO", 0);
    verbHashMap.put("MOVE", 0);
    verbHashMap.put("LOOK", 1);
    verbHashMap.put("LOOKAROUND", 1);
    verbHashMap.put("LOOKAT", 2);
    verbHashMap.put("EXAMINE", 2);
    verbHashMap.put("INSPECT", 2);
    verbHashMap.put("VIEW", 2);
    verbHashMap.put("TAKE", 3);
    verbHashMap.put("GET", 3);
    verbHashMap.put("PICKUP", 3);
    verbHashMap.put("FIGHT", 4);
    verbHashMap.put("KILL", 4);
    verbHashMap.put("STAB", 4);
    verbHashMap.put("DESTROY", 4);
    verbHashMap.put("PUSH", 5);
    verbHashMap.put("PRESS", 5);
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

  public static HashMap<String, Integer> getVerbs() {
    return verbHashMap;
  }
}
