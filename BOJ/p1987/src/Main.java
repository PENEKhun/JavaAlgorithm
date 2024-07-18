import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1987 알파벳
  https://www.acmicpc.net/problem/1987
*/

public class Main {
  static int result = Integer.MIN_VALUE;
  static int[][] delta = {
      // 상 하 좌 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };
  static int height;
  static int width;
  static char[][] board;

  static void dfs(int x, int y, int depth, boolean[] visited) {
    result = Math.max(result, depth);
    if (depth >= height * width) {
      return;
    }

    for (int[] dxy : delta) {
      int newX = x + dxy[0];
      int newY = y + dxy[1];

      if ((newX < 0 || newX >= width) || (newY < 0 || newY >= height)) {
        continue;
      }

      if (visited[board[newY][newX] - 'A']) {
        continue;
      }

      visited[board[newY][newX] - 'A'] = true;
      dfs(newX, newY, depth + 1, visited);
      visited[board[newY][newX] - 'A'] = false;
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] RC = br.readLine().split(" ");
    height = Integer.parseInt(RC[0]);
    width = Integer.parseInt(RC[1]);

    board = new char[height][width];
    for (int i = 0; i < height; i++) {
      board[i] = br.readLine().toCharArray();
    }

    boolean[] visited = new boolean['a' - 'A'];
    visited[board[0][0] - 'A'] = true;
    dfs(0, 0, 1, visited);
    System.out.println(result);
  }
}
