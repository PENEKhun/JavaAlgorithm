import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/*
  BAEKJOON 1926 그림
  https://www.acmicpc.net/problem/1926
*/

public class Main {

  static Boolean[][] graph;
  static int[][] d = new int[][] {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}
  };
  static int[][] results;

  public static void dfs(int x, int y, int startX, int startY) {
    if (!graph[y][x]) {
      return;
    }

    results[startY][startX]++;
    graph[y][x] = false;

    for (int[] dxy : d) {
      int newX = x + dxy[0];
      int newY = y + dxy[1];

      if (newX < 0 || newX > graph[0].length - 1) {
        continue;
      }
      if (newY < 0 || newY > graph.length - 1) {
        continue;
      }

      if (graph[newY][newX]) {
        dfs(newX, newY, startX, startY);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int width = Integer.parseInt(inputs[1]);
    int height = Integer.parseInt(inputs[0]);
    graph = new Boolean[height][width];
    results = new int[height][width];

    for (int i = 0; i < height; i++) {
      graph[i] = Arrays.stream(br.readLine().split(" "))
          .map(value -> Objects.equals(value, "1"))
          .toArray(Boolean[]::new);
    }

    int pictureLength = 0;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (graph[y][x]) {
          pictureLength++;
          dfs(x, y, x, y);
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int[] result : results) {
      for (int i : result) {
        max = Math.max(max, i);
      }
    }

    System.out.println(pictureLength);
    System.out.println(max);
  }
}