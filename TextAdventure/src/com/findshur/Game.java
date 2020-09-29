package com.findshur;

public class Game {
  public static void main(String[] args) {
    var parser = Parser.getInstance("This is the only parser.");
    System.out.println(parser.value);
  }
}
