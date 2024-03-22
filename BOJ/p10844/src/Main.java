import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 10844 쉬운 계단 수
  https://www.acmicpc.net/problem/10844
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    long[][] dp = new long[n + 1][10];
    for (int i = 1; i < 10; i++) {
      dp[1][i] = 1;
    }

    int num = 1_000_000_000;
    for (int i = 2; i < n + 1; i++) {
      for (int k = 0; k < 10; k++) {
        if (k == 0) {
          dp[i][k] = (dp[i - 1][k + 1]) % num;
        } else if (k < 9) {
          dp[i][k] = (dp[i - 1][k - 1] + dp[i - 1][k + 1]) % num;
        } else {
          dp[i][k] = (dp[i - 1][k - 1]) % num;
        }
      }
    }

    System.out.println(Arrays.stream(dp[n]).sum() % num);
  }
}