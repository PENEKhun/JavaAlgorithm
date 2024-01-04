import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/*
    BAEKJOON 21736 헌내기는 친구가 필요해
    https://www.acmicpc.net/problem/21736
*/

public class Main {
  static int result = 0;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static String[][] map;
  static boolean[][] visited;
  static String WALL = "X";
  static String PEOPLE = "P";
  static String CANGO = "O";

  public static void dfs(int x, int y){
    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if (newY < 0 || newY > map.length - 1) {
        continue;
      }

      if (newX < 0 || newX > map[0].length - 1) {
        continue;
      }

      if (visited[newY][newX]) {
        continue;
      }

      if (map[newY][newX].equals(PEOPLE)) {
        visited[newY][newX] = true;
        result++;
        dfs(newX, newY);
      } else if (map[newY][newX].equals(CANGO)) {
        visited[newY][newX] = true;
        dfs(newX, newY);
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    map = new String[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().split("");
    }

    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (Objects.equals(map[y][x], "I")) {
          visited[y][x] = true;
          dfs(x, y);
          break;
        }
      }
    }

    if (result == 0){
      System.out.println("TT");
    } else {
      System.out.println(result);
    }
  }
}
