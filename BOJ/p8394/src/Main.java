import java.util.Scanner;

/*
    BAEKJOON 8394 악수
    https://www.acmicpc.net/problem/8394
*/

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long[] dp = new long[n+3];
    dp[1] = 1L;
    dp[2] = 2L;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i-2] + dp[i-1]) % 10;
    }

    System.out.println(dp[n]);
  }
}
