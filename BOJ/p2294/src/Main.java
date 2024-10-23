import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2294 동전 2
  https://www.acmicpc.net/problem/2294
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int K = Integer.parseInt(inputs[1]);
    int[] coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[K + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int coinValue : coins) {
      for (int i = coinValue; i <= K; i++) {
        if (dp[i - coinValue] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coinValue] + 1);
        }
      }
    }

    if (dp[K] == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(dp[K]);
    }
  }
}
