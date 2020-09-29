package com.findshur;

import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    var parser = Parser.getInstance();
    var in = new Scanner(System.in);

    var input = in.nextLine();
    var command = parser.parse(input);

    System.out.println(command);
    in.close();
  }
}
