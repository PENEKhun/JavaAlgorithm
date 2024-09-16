import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 14405 피카츄
  https://www.acmicpc.net/problem/14405
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    while (s.contains("pi") || s.contains("ka") || s.contains("chu")) {
      s = s.replace("pi", " ");
      s = s.replace("ka", " ");
      s = s.replace("chu", " ");
    }

    s = s.replaceAll(" ", "");
    if (s.isEmpty()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
