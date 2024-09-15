import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 11057 오르막 수
  https://www.acmicpc.net/problem/11057
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n+1][11];
    Arrays.fill(dp[1], 1);

    if (n == 1) {
      System.out.println(10);
      return;
    }

    for (int round = 2; round <= n; round++) {
      for (int i = 1; i <= 10; i++) {
        dp[round][i] = (dp[round - 1][i] + dp[round][i-1]) % 10_007;
      }
    }

    int result = 0;
    for (int i = 0; i <= 10; i++) {
      result += dp[n][i];
    }

    System.out.println(result % 10_007);
  }
}
