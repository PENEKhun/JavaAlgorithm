import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 11055 가장 큰 증가하는 부분 수열
  https://www.acmicpc.net/problem/11055
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] dp = new int[N];
    int max = arr[0];

    for (int i = 0; i < N; i++) {
      dp[i] = arr[i];
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
