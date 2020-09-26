import java.util.Scanner;

public class Game {

  public static void main(String[] args) {
    Thing book = new Thing(0, "Book", "This is a book", false);
    Scanner in = new Scanner(System.in);
    System.out.println("Which item do you want to check?");
    String input = in.nextLine();
    if (input.equals("book")) {
      System.out.println(book.getName());
      System.out.println(book.getDescription());
    }
    in.close();
  }
}