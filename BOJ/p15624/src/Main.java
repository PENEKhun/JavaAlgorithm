import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 15624 피보나치 수 7
  https://www.acmicpc.net/problem/15624
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    final int DIVIDER = 1_000_000_007;
    long[] dp = new long[n + 2];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % DIVIDER;
    }

    System.out.println(dp[n]);
  }
}