import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1952 달팽이2
  https://www.acmicpc.net/problem/1952
*/

public class Main {

  static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  static int maxX;
  static int maxY;
  static boolean[][] visited;
  static int result = 0;

  public static void solution(int x, int y, int path) {
    visited[y][x] = true;

    int newX = x + direction[path][0];
    int newY = y + direction[path][1];
    if ((newX >= maxX || newY >= maxY) || (newX < 0 || newY < 0) || visited[newY][newX]) {
      // change Direction
      path = switch (path) {
        case 0 -> 1;
        case 1 -> 2;
        case 2 -> 3;
        case 3 -> 0;
        default -> throw new IllegalStateException("Unexpected value: " + path);
      };

      newX = x + direction[path][0];
      newY = y + direction[path][1];
      if (visited[newY][newX]) {
        return;
      }

      result++;
    }
    solution(newX, newY, path);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    maxY = Integer.parseInt(input[0]);
    maxX = Integer.parseInt(input[1]);
    visited = new boolean[maxY][maxX];
    solution(0, 0, 0);
    System.out.println(result);
  }
}