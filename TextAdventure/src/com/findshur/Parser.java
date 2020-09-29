package com.findshur;

import com.findshur.Enums.Articles;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * Class which is made in the Singleton design pattern. There can be only one
 * Parser instance. This singleton is safe for use in multithreaded environments
 * due to the synchronizing of the threads.
 */
public final class Parser {
  private static volatile Parser instance;

  private EnumSet<Articles> articles = EnumSet.allOf(Articles.class);
  private HashSet<Articles> articlesHashSet = new HashSet<Articles>(articles);

  private Parser(String value) {
    this.value = value;
  }

  public static Parser getInstance(String value) {
    Parser result = instance;
    if (result != null) {
      return result;
    }
    synchronized (Parser.class) {
      if (instance == null) {
        instance = new Parser(value);
      }
      return instance;
    }
  }
}
