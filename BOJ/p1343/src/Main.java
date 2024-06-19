import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1343 폴리오미노
  https://www.acmicpc.net/problem/1343
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String boardPan = br.readLine();
    String replacedPan = boardPan.replace("XXXX", "AAAA").replace("XX", "BB");
    if (replacedPan.contains("X")) {
      System.out.println("-1");
    } else {
      System.out.println(replacedPan);
    }
  }
}