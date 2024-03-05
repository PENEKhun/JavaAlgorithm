import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2293 동전 1
  https://www.acmicpc.net/problem/2293
*/

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] coins = new int[input[0]];
    int k = input[1];
    int[] dp = new int[k+1];

    for (int i = 0; i < coins.length; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }
    coins = Arrays.stream(coins).sorted().toArray();
    dp[0] = 1;

    for (int coin : coins) {
      for (int i = 1; i <= k; i++) {
        if (coin <= i) {
          dp[i] += dp[i-coin];
        }
      }
    }

    System.out.println(dp[k]);
  }
}