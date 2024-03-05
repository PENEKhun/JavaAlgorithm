import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
  BAEKJOON 2293 동전 1
  https://www.acmicpc.net/problem/2293
*/

public class Main {

  // dp[가치][] = {쪼갤 수 있는 동전}
  static int[][] dp;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] coins = new int[input[0] + 1];
    int k = input[1];

    for (int i = 0; i < coins.length - 1; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }
    coins[coins.length - 1] = k;
    coins = Arrays.stream(coins).sorted().toArray();

    dp = new int[k + 1][1];
    for (int i = coins.length - 1; i >= 0; i--) {
      int remain = coins[i];
      ArrayList<Integer> coinDivide = new ArrayList<>();
      for (int j = i - 1; j >= 0; j--) {
        for (int q = (remain / coins[j]); q > 0; q--) {
          coinDivide.add(coins[j]);
          remain -= coins[j];
        }

        if (remain == 0) {
          int[] arr = new int[coinDivide.size()];
          for (int q = 0; q < arr.length; q++) {
            arr[q] = coinDivide.get(q);
          }

          dp[coins[i]] = arr;
          break;
        }
      }
    }

    long result = 0;
    for (int i = dp.length - 1; i >= 0; i--) {
      int[] coinDiv = dp[i];
      for (int coin : coinDiv) {
        result += Arrays.stream(dp[coin]).filter(s -> s != 0).count();
      }
    }

    System.out.println(result);
  }
}