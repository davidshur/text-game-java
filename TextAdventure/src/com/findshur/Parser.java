package com.findshur;

public final class Parser {
  public static String parse(String command) {
    String[] formattedCommand = formatString(command);
    return formattedCommand[0];
  }

  private static String[] formatString(String s) {
    var a = s.replaceAll("[^a-zA-Z ]", "").toUpperCase().split("\\s+");
    return a;
  }
}
