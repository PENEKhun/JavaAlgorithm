import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Stream.of(s.nextInt(), s.nextInt(), s.nextInt()).sorted()
        .forEach(
            i -> {
              System.out.printf(String.valueOf(i));
              System.out.print(" ");
            }
        );
  }
}