import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
      BAEKJOON 1541 잃어버린 괄호
      https://www.acmicpc.net/problem/1541
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] split = input.split("(?<=\\d)(?=[+\\-])|(?<=[+\\-])(?=\\d)");
    boolean minusBefore = false;
    int num = Integer.parseInt(split[0]);
    for (int i = 1; i < split.length; i++) {
      String a = split[i];
      if (a.equals("-")) {
        minusBefore = true;
      }

      if (a.matches("[0-9]*")) {
        int now = Integer.parseInt(a);
        num = num + (minusBefore ? -now : now);
      }
    }

    System.out.println(num);
  }
}
