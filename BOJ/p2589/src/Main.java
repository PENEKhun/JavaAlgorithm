import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 2589 보물섬
  https://www.acmicpc.net/problem/2589
*/

public class Main {
  static int result = 0;
  static int height, width;
  static Boolean[][] map;
  static int[][] dxy = new int[][] {
      // 상, 하, 좌, 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public static void bfs(int startX, int startY) {
    boolean[][] visited = new boolean[height][width];
    // {x, y, duration}
    Queue<int[]> q = new LinkedList<>();
    visited[startY][startX] = true;
    q.add(new int[]{startX, startY, 0});

    while (!q.isEmpty()) {
      int[] poll = q.poll();
      int x = poll[0];
      int y = poll[1];
      int duration = poll[2];
      result = Math.max(result, duration);

      for (int[] xy : dxy) {
        int newX = x + xy[0];
        int newY = y + xy[1];

        if (newX < 0 || newX >= width || newY < 0 || newY >= height) continue;
        if (map[newY][newX] && !visited[newY][newX]) {
          visited[newY][newX] = true;
          q.add(new int[]{newX, newY, duration + 1});
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    height = Integer.parseInt(inputs[0]);
    width = Integer.parseInt(inputs[1]);
    // 육지 == true, 못가는곳은 false
    map = new Boolean[height][];
    for (int i = 0; i < height; i++) {
      map[i] = Arrays.stream(br.readLine().split("")).map(s -> s.equals("L")).toArray(Boolean[]::new);
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (map[y][x]) {
          bfs(x, y);
        }
      }
    }

    System.out.println(result);
  }
}
