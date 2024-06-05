import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import javax.swing.Icon;

/*
  BAEKJOON 11123 양 한마리... 양 두마리...
  https://www.acmicpc.net/problem/11123
*/

public class Main {

  static boolean[][] visited;
  static Boolean[][] grid;
  static int[][] d = new int[][] {
      // x, y
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  static int result = 0;
  public static void dfs(int x, int y) {
    visited[y][x] = true;

    for (int[] dxy : d) {
      int newX = x + dxy[0];
      int newY = y + dxy[1];

      if (newX < 0 || newX > grid[0].length - 1) {
        continue;
      }

      if (newY < 0 || newY > grid.length - 1) {
        continue;
      }

      if (grid[newY][newX] && !visited[newY][newX]) {
        dfs(newX, newY);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      String[] inputs = br.readLine().split(" ");
      int H = Integer.parseInt(inputs[0]);
      int W = Integer.parseInt(inputs[1]);
      grid = new Boolean[H][W];
      // init
      visited = new boolean[H][W];
      result = 0;

      for (int k = 0; k < H; k++) {
        grid[k] = Arrays.stream(br.readLine().split(""))
            .map(s -> s.equals("#"))
            .toArray(Boolean[]::new);
      }

      for (int y = 0; y < H; y++) {
        for (int x = 0; x < W; x++) {
          if (grid[y][x] && !visited[y][x]) {
            result++;
            dfs(x, y);
          }
        }
      }

      bw.write(result + "\n");
    }

    bw.flush();
  }
}