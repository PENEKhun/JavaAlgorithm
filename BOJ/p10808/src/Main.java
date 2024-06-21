import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 10808 알파벳 개수
  https://www.acmicpc.net/problem/10808
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    short[] cnt = new short['z' - 'a' + 1];
    char[] input = br.readLine().toCharArray();
    for (char c : input) {
      cnt[c - 'a']++;
    }
    StringBuilder result = new StringBuilder();
    for (short i : cnt) {
      result.append(i).append(" ");
    }
    System.out.println(result);
  }
}