import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 9465 스티커
  https://www.acmicpc.net/problem/9465
*/

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int testCase = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < testCase; i++) {
      int width = Integer.parseInt(br.readLine());
      int[][] sticker = new int[2][];
      sticker[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      sticker[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int[][][] dp = new int[2][width][2]; // y x bool

      if (width == 1) {
        result.append(Math.max(sticker[0][0], sticker[1][0])).append("\n");
        continue;
      }

      for (int x = 0; x < width; x++) {
        for (int y = 0; y < 2; y++) {
          dp[y][x][1] = sticker[y][x];
        }
      }

      int max = Integer.MIN_VALUE;
      for (int x = 1; x < width; x++) {
        dp[1][x][0] = dp[1][x - 1][1];
        dp[1][x][1] = Math.max(dp[0][x - 1][1], dp[0][x - 1][0]) + sticker[1][x];
        max = Math.max(dp[1][x][0], max);
        max = Math.max(dp[1][x][1], max);

        dp[0][x][0] = dp[0][x - 1][1];
        dp[0][x][1] = Math.max(dp[1][x - 1][1], dp[1][x - 1][0]) + sticker[0][x];
        max = Math.max(dp[0][x][0], max);
        max = Math.max(dp[0][x][1], max);
      }

      result.append(max).append("\n");
    }
    bw.write(String.valueOf(result));
    bw.flush();
  }
}
