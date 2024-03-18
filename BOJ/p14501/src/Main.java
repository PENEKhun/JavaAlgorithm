import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 14501 퇴사
  https://www.acmicpc.net/problem/14501
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int day = Integer.parseInt(br.readLine());
    int[] times = new int[day + 1];
    int[] paid = new int[day + 1];
    int[] dp = new int[day + 2];

    for (int i = 1; i < times.length; i++) {
      String[] input = br.readLine().split(" ");
      times[i] = Integer.parseInt(input[0]);
      paid[i] = Integer.parseInt(input[1]);
    }

    for (int i = 1; i <= day; i++) {
      int workEnd = i + times[i];
      if (workEnd > day + 1)
        continue;

      int maxDp = -1;
      for (int k = i; k > 0; k--) {
        maxDp = Math.max(maxDp, dp[k]);
      }

      dp[workEnd] = Math.max(maxDp + paid[i], dp[workEnd]);
    }

    System.out.println(Arrays.stream(dp).max().getAsInt());
  }
}