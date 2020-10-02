package com.findshur;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Parser made in the Singleton design pattern.
 */
public final class Parser {
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
   * Takes a command and formats it.
   * 
   * @param command A string to be parsed.
   * @return The first word of the command.
   */
  public static String parse(String command) {
    String[] formattedCommand = formatString(command);
    return formattedCommand[0];
  }

  /**
   * Formats and splits a string to an array.
   * 
   * @param s A string.
   * @return Array that has been formatted and split to words containing only
   *         upper-case letters and no symbols.
   */
  private static String[] formatString(String s) {
    var a = s.replaceAll("[^a-zA-Z ]", "").toUpperCase().split("\\s+");
    return a;
  }
}
