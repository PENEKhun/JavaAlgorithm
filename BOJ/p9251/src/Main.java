import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 9251 LCS
  https://www.acmicpc.net/problem/9251
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = new String[2];
    for (int i = 0; i < 2; i++) {
      str[i] = br.readLine();
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int len0 = str[0].length();
    int len1 = str[1].length();
    int[][] dp = new int[len0 + 1][len1 + 1];

    for (int i = 1; i <= len0; i++) {
      for (int k = 1; k <= len1; k++) {
        if (str[0].charAt(i - 1) == str[1].charAt(k - 1)) {
          dp[i][k] = dp[i - 1][k - 1] + 1;
        } else {
          dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]);
        }
      }
    }
    bw.write(dp[len0][len1] + "\n");
    bw.flush();
  }
}