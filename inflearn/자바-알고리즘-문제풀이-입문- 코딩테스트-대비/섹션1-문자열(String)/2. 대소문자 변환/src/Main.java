import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String input = s.nextLine();
    IntStream chars = input.chars();
    int diff = 'A' - 'a';
    chars.forEach(
        ch -> {
          if (ch >= 'a') {
            System.out.print(Character.valueOf((char) (ch + diff)));
          } else {
            System.out.print(Character.valueOf((char) (ch - diff)));
          }
        }
    );
  }
}