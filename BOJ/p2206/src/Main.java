import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
  BAEKJOON 2206 벽 부수고 이동하기
  https://www.acmicpc.net/problem/2206
*/

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int n = Integer.parseInt(NM[0]);
    int m = Integer.parseInt(NM[1]);
    boolean[][] matrix = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        matrix[i][j] = line.charAt(j) == '1';
      }
    }

    int[][] delta = {
        // 상 하 좌 우
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[] {0, 0, 1, 1});

    int result = Integer.MIN_VALUE;
    boolean[][][] visited = new boolean[n][m][2];
    visited[0][0][1] = true;

    while (!q.isEmpty()) {
      int[] poll = q.poll();
      int x = poll[0];
      int y = poll[1];
      int breakWall = poll[2];
      int times = poll[3];

      if (x == m - 1 && y == n - 1) {
        result = times;
        break;
      }

      for (int[] dxy : delta) {
        int newX = x + dxy[0];
        int newY = y + dxy[1];
        if ((newX < 0 || newX >= m) || newY < 0 || newY >= n) {
          continue;
        }

        int remainBreak = breakWall;
        if (matrix[newY][newX]) {
          if (breakWall == 0) {
            continue;
          }
          remainBreak--;
        }

        if (!visited[newY][newX][remainBreak]) {
          visited[newY][newX][remainBreak] = true;
          q.add(new int[] {newX, newY, remainBreak, times + 1});
        }
      }
    }

    if (result == Integer.MIN_VALUE) {
      System.out.println("-1");
    } else {
      System.out.println(result);
    }
  }
}
