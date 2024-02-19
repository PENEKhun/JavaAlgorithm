import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 11722 가장 긴 감소하는 부분 수열
  https://www.acmicpc.net/problem/11722
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n];
    int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int k = 0; k < i; k++) {
        // 앞 숫자가 큰게 있으면
        if (nums[i] < nums[k]) {
          dp[i] = Math.max(dp[i], dp[k] + 1);
        }
      }
    }

    System.out.println(Arrays.stream(dp).max().getAsInt());
  }
}