import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 17090 미로 탈출하기
  https://www.acmicpc.net/problem/17090
*/

public class Main {
  static int result = 0;
  static int width, height;
  static char[][] map;
  static int[][] memo; // 0 : 아직 모름, 1: 탈출 가능, -1 : 탈출 불가능

  static int dfs(int x, int y) {
    if (memo[y][x] != 0) {
      return memo[y][x];
    }

    char direction = map[y][x];
    int nextX = x, nextY = y;
    if (direction == 'U') {
      nextY--;
    } else if (direction == 'R') {
      nextX++;
    } else if (direction == 'D') {
      nextY++;
    } else if (direction == 'L') {
      nextX--;
    }

    if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
      result++;
      return memo[y][x] = 1;
    }

    if (memo[y][x] == -1) {
      return memo[y][x] = -1;
    }

    memo[y][x] = -1;
    memo[y][x] = dfs(nextX, nextY);
    if (memo[y][x] == 1) {
      result++;
    }
    return memo[y][x];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    height = Integer.parseInt(NM[0]);
    width = Integer.parseInt(NM[1]);
    map = new char[height][];
    for (int i = 0; i < height; i++) {
      map[i] = br.readLine().toCharArray();
    }

    memo = new int[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (memo[y][x] == 0) {
          dfs(x, y);
        }
      }
    }

    System.out.println(result);
  }
}
