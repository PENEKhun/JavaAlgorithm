import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
  BAEKJOON 1261 알고스팟
  https://www.acmicpc.net/problem/1261
*/

public class Main {
  static int[][] delta = new int[][] {
      // 상, 하, 좌, 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int width = Integer.parseInt(input[0]);
    int height = Integer.parseInt(input[1]);

    Boolean[][] map = new Boolean[height][];
    for (int y = 0; y < height; y++) {
      map[y] = Arrays.stream(br.readLine().split("")).map(s -> s.equals("1")).toArray(Boolean[]::new);
    }

    int[][] minCost = new int[height][width];
    for (int[] row : minCost) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    minCost[0][0] = 0;

    // reach to width-1, height-1
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

    pq.add(new int[]{0, 0, 0});
    int result = 0;
    while (!pq.isEmpty()) {
      int[] step = pq.poll();
      int x = step[0];
      int y = step[1];
      int cost = step[2];

      if (x == width - 1 && y == height - 1) {
        System.out.println(cost);
        return;
      }

      if (cost > minCost[y][x]) {
        continue;
      }

      for (int[] dxy : delta) {
        int newX = dxy[0] + x;
        int newY = dxy[1] + y;

        if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
          continue;
        }

        int newCost = cost + (map[newY][newX] ? 1 : 0);
        if (newCost < minCost[newY][newX]) {
          minCost[newY][newX] = newCost;
          pq.add(new int[]{newX, newY, newCost});
        }
      }
    }

    System.out.println(result);
  }
}
