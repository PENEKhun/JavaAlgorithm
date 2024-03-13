import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 1149 RGB거리
  https://www.acmicpc.net/problem/1149
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] costs = new int[n + 1][3];
    for (int i = 1; i <= n; i++) {
      int[] rgb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      costs[i] = new int[] {rgb[0], rgb[1], rgb[2]};
    }

    int[][] dp = new int[n + 1][3];
    dp[1] = costs[1];

    for (int i = 2; i <= n; i++) {
      dp[i][0] = Math.min(
          dp[i - 1][1] + costs[i][0],
          dp[i - 1][2] + costs[i][0]
      );

      dp[i][1] = Math.min(
          dp[i - 1][0] + costs[i][1],
          dp[i - 1][2] + costs[i][1]
      );

      dp[i][2] = Math.min(
          dp[i - 1][0] + costs[i][2],
          dp[i - 1][1] + costs[i][2]
      );
    }

    System.out.println(Arrays.stream(dp[n]).min().getAsInt());
  }
}