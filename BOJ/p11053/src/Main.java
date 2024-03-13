import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 11053 가장 긴 증가하는 부분 수열
  https://www.acmicpc.net/problem/11053
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] dp = new int[n];

    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      int max = 1;
      for (int k = i - 1; k >= 0; k--) {
        if (numbers[k] < numbers[i]) {
          max = Math.max(dp[k] + 1, max);
        }

        dp[i] = max;
      }

    }

    System.out.println(Arrays.stream(dp).max().getAsInt());
  }
}