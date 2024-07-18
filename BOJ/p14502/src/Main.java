import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 14502 연구소
  https://www.acmicpc.net/problem/14502
*/

public class Main {
  static int maxX;
  static int maxY;
  static int[][] map;
  static int[][] delta = {
      // 상 하 좌 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };
  static boolean[][] visited;
  static int result = Integer.MIN_VALUE;

  static void spread(int x, int y) {
    map[y][x] = 2;

    for (int[] dxy : delta) {
      int newX = x + dxy[0];
      int newY = y + dxy[1];

      if ((newX < 0 || newX >= maxX) || (newY < 0 || newY >= maxY)) {
        continue;
      }

      if (map[newY][newX] == 0) {
        spread(newX, newY);
      }
    }
  }

  static void guard(int x, int y, int depth) {
    if (depth == 3) {
      int[][] mem = new int[maxY][];
      for (int i = 0; i < maxY; i++) {
        mem[i] = map[i].clone();
      }

      for (int newX = 0; newX < maxX; newX++) {
        for (int newY = 0; newY < maxY; newY++) {
          if (map[newY][newX] == 2) {
            spread(newX, newY);
          }
        }
      }
      int cnt = 0;
      for (int newX = 0; newX < maxX; newX++) {
        for (int newY = 0; newY < maxY; newY++) {
          if (map[newY][newX] == 0) {
            cnt++;
          }
        }
      }

      result = Math.max(result, cnt);
      map = mem;
      return;
    }

    for (int newX = x; newX < maxX; newX++) {
      for (int newY = 0; newY < maxY; newY++) {
        if (map[newY][newX] == 0) {
          map[newY][newX] = 1;
          guard(newX, newY, depth + 1);
          map[newY][newX] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    maxY = Integer.parseInt(nm[0]);
    maxX = Integer.parseInt(nm[1]);
    map = new int[maxY][];
    for (int i = 0; i < maxY; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    visited = new boolean[maxY][maxX];
    guard(0, 0, 0);
    System.out.println(result);
  }
}
