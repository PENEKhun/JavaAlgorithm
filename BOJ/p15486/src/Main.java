import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 15486 퇴사 2
  https://www.acmicpc.net/problem/15486
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] p = new int[n + 2];
    int[] t = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      String[] input = br.readLine().split(" ");
      t[i] = Integer.parseInt(input[0]);
      p[i] = Integer.parseInt(input[1]);
    }

    int[] dp = new int[n + 2];
    int max = -1;
    for (int now = 1; now <= n + 1; now++) {
      max = Math.max(dp[now], max);
      int afterWork = now + t[now];
      if (afterWork <= n + 1) {
        dp[afterWork] = Math.max(dp[afterWork], max + p[now]);
      }
    }

    System.out.println(dp[n + 1]);
  }
}
