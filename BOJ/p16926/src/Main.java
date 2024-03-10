import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 16926 배열 돌리기 1
  https://www.acmicpc.net/problem/16926
*/

public class Main {

  static boolean[][] visited;
  static int[][] arr;

  public static void snake(int yx[], int prevVal, int dydx[], int minY, int minX, int maxY, int maxX) {
    int y = yx[0];
    int x = yx[1];

    // 방문 체크
    if (visited[y][x]) {
      if (maxY <= y + 1 || maxX <= x + 2) {
        return;
      }

      snake(new int[] {y + 1, x + 1}, arr[y + 1][x + 2], new int[] {1, 0}, minY + 1, minX + 1, maxY - 1,
          maxX - 1);
      return;
    }

    visited[y][x] = true;
    int temp = arr[y][x];
    arr[y][x] = prevVal;

    // 다음 방향 정하기
    int nextY = y + dydx[0];
    int nextX = x + dydx[1];
    if (nextY < minY || maxY <= nextY ||
        nextX < minX || maxX <= nextX) {
      // 방향 틀기
      if (dydx[0] == 1 && dydx[1] == 0) {
        dydx = new int[] {0, 1};
      } else if (dydx[0] == 0 && dydx[1] == 1) {
        dydx = new int[] {-1, 0};
      } else if (dydx[0] == -1 && dydx[1] == 0) {
        dydx = new int[] {0, -1};
      } else if (dydx[0] == 0 && dydx[1] == -1) {
        dydx = new int[] {1, 0};
      }

      nextY = y + dydx[0];
      nextX = x + dydx[1];
    }

    snake(new int[] {nextY, nextX}, temp, dydx, minY, minX, maxY, maxX);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int n = input[0];
    int m = input[1];
    int spin = input[2];

    arr = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int i = 0; i < spin; i++) {
      snake(new int[] {0, 0}, arr[0][1], new int[] {1, 0}, 0, 0, n, m);
      visited = new boolean[n][m];
    }

    for (int[] ints : arr) {
      System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).reduce((a, b) -> a + " " + b)
          .get());
    }
  }
}