import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
    ArrayList<Mountain> mountains = new ArrayList<>();
    Map<Integer, ArrayList<Mountain>> roads = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      roads.put(i, new ArrayList<>());
      mountains.add(new Mountain(i, heights[i - 1]));
    }

    for (int i = 0; i < M; i++) {
      int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      roads.get(road[0]).add(new Mountain(road[1], heights[road[1] - 1]));
      roads.get(road[1]).add(new Mountain(road[0], heights[road[0] - 1]));
    }

    int[] dp = new int[N + 1];
    Arrays.fill(dp, 1);
    mountains.sort((o1, o2) -> Integer.compare(o2.height, o1.height));
    for (int i = 0; i < mountains.size(); i++) {
      Mountain nowMountain = mountains.get(i);
      int nowNumber = nowMountain.number;
      int nowHeight = nowMountain.height;
      int max = -1;
      for (Mountain nextMountain : roads.get(nowNumber)) {
        if (nowHeight < nextMountain.height) {
          max = Math.max(max, dp[nextMountain.number]);
        }
      }

      if (max != -1) {
        dp[nowNumber] += max;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(dp[i]).append("\n");
    }

    System.out.printf(String.valueOf(sb));
  }
}
