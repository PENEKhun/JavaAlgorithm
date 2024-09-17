import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 13417 카드 문자열
  https://www.acmicpc.net/problem/13417
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    for (int testCase = 0; testCase < T; testCase++) {
      StringBuilder temp = new StringBuilder();
      int n = Integer.parseInt(br.readLine());
      char[] alphabet = br.readLine().replace(" ", "").toCharArray();
      temp.append(alphabet[0]);
      for (int i = 1; i < alphabet.length; i++) {
        char pick = alphabet[i];
        if (pick <= temp.charAt(0)) { // 사전순으로 빠른지
          temp.insert(0, pick);
        } else {
          temp.append(pick);
        }
      }
      result.append(temp).append("\n");
    }
    System.out.printf(String.valueOf(result));
  }
}
