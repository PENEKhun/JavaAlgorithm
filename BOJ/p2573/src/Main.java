import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2573 빙산
  https://www.acmicpc.net/problem/2573
*/

public class Main {
  static int[][] dxy = new int[][] {
      // 상 하 좌 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  static boolean[][] visited;
  static int[][] map;
  static int height;
  static int width;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    height = Integer.parseInt(NM[0]); // 행의 개수
    width = Integer.parseInt(NM[1]); // 열의 개수

    map = new int[height][width];
    for (int y = 0; y < height; y++) {
      map[y] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int year = 0;
    while (true) {
      visited = new boolean[height][width];
      int icebergCount = 0;
      boolean allMelted = true;

      // 빙산의 개수 세기
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          if (map[y][x] > 0 && !visited[y][x]) {
            icebergCount++;
            if (icebergCount >= 2) {
              System.out.println(year);
              return;
            }
            dfs(x, y);
          }
        }
      }

      // 모든 빙산이 녹았는지 확인
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          if (map[y][x] > 0) {
            allMelted = false;
            break;
          }
        }
        if (!allMelted) {
          break;
        }
      }

      if (allMelted) {
        System.out.println(0);
        return;
      }

      // 빙산 녹이기
      int[][] melt = new int[height][width];
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          if (map[y][x] > 0) {
            int waterCount = 0;
            for (int[] xy : dxy) {
              int newY = y + xy[0];
              int newX = x + xy[1];
              if (newY >= 0 && newY < height && newX >= 0 && newX < width) {
                if (map[newY][newX] == 0) {
                  waterCount++;
                }
              }
            }
            melt[y][x] = waterCount;
          }
        }
      }

      // 녹은 빙산 적용
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          map[y][x] = Math.max(0, map[y][x] - melt[y][x]);
        }
      }

      year++;
    }
  }

  private static void dfs(int x, int y) {
    visited[y][x] = true;

    for (int[] xy : dxy) {
      int newY = y + xy[0];
      int newX = x + xy[1];

      if (newY >= 0 && newY < height && newX >= 0 && newX < width) {
        if (map[newY][newX] > 0 && !visited[newY][newX]) {
          dfs(newX, newY);
        }
      }
    }
  }
}
