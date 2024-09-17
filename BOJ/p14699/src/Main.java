import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  BAEKJOON 14699 관악산 등산
  https://www.acmicpc.net/problem/14699
*/

public class Main {
  public static class Mountain {
    int number;
    int height;

    public Mountain(int number, int height) {
      this.number = number;
      this.height = height;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]); // 쉼터의 수
    int M = Integer.parseInt(inputs[1]);  // 쉼터 오가는 수
    int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    boolean[][] hasRoute = new boolean[N + 1][N + 1];
    List<Mountain> mountains = new ArrayList<>();

    for (int i = 0; i < heights.length; i++) {
      mountains.add(new Mountain(i + 1, heights[i]));
    }

    for (int i = 0; i < M; i++) {
      int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      if (heights[road[0] - 1] < heights[road[1] - 1]) {
        hasRoute[road[0]][road[1]] = true;
      } else if (heights[road[0] - 1] > heights[road[1] - 1]) {
        hasRoute[road[1]][road[0]] = true;
      }
    }

    int[] dp = new int[N + 1];
    Arrays.fill(dp, 1);
    mountains.sort((o1, o2) -> Integer.compare(o2.height, o1.height));
    for (int i = 0; i < mountains.size(); i++) {
      Mountain nowMountain = mountains.get(i);
      int max = -1;
      for (int next = 1; next <= N; next++) {
        if (nowMountain.number == next)
          continue;

        if (hasRoute[nowMountain.number][next]) {
          max = Math.max(max, dp[next]);
        }
      }

      if (max != -1) {
        dp[nowMountain.number] += max;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(dp[i]).append("\n");
    }

    System.out.printf(String.valueOf(sb));
  }
}
