import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 2156 포도주 시식
  https://www.acmicpc.net/problem/2156
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] wines = new int[n + 1];
    // [][0]: 마시지 않음, 1: 1잔 연속, 2: 2잔 연속
    int[][] dp = new int[n + 1][3];
    for (int i = 1; i <= n; i++) {
      wines[i] = Integer.parseInt(br.readLine());
    }

    dp[1][1] = wines[1];
    dp[1][2] = wines[1];

    for (int i = 2; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
      dp[i][1] = dp[i - 1][0] + wines[i];
      dp[i][2] = dp[i - 1][1] + wines[i];
    }

    int result = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
    System.out.println(result);
  }
}