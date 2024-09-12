import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 14503 로봇 청소기
  https://www.acmicpc.net/problem/14503
*/

public class Main {
  public static class Cleaner {
    public int x;
    public int y;
    public Direction direction;

    public Cleaner(int x, int y, Direction direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }

    public void turn() {
      direction = this.direction.turn();
    }
  }

  public enum Direction {
    UP(0, -1),
    LEFT(-1, 0),
    DOWN(0, 1),
    RIGHT(1, 0);

    Direction(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }

    public int dx;
    public int dy;

    public Direction turn() {
      return switch (this) {
        case UP -> LEFT;
        case LEFT -> DOWN;
        case DOWN -> RIGHT;
        case RIGHT -> UP;
      };
    }

    public static Direction num2Direction(int number) {
      return switch (number) {
        case 0 -> UP;
        case 1 -> RIGHT;
        case 2 -> DOWN;
        case 3 -> LEFT;
        default -> throw new RuntimeException("err");
      };
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    input = br.readLine().split(" ");
    Cleaner cleaner = new Cleaner(Integer.parseInt(input[1]), Integer.parseInt(input[0]),
        Direction.num2Direction(Integer.parseInt(input[2])));
    int[][] room = new int[n][m];
    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        room[i][j] = Integer.parseInt(input[j]);
      }
    }

    int result = 0;
    while (true) {
      if (room[cleaner.y][cleaner.x] == 0) {
        room[cleaner.y][cleaner.x] = 2;
        result++;
      }

      boolean cleaned = false;
      for (int i = 0; i < 4; i++) {
        cleaner.turn();
        int newX = cleaner.x + cleaner.direction.dx;
        int newY = cleaner.y + cleaner.direction.dy;

        if (newX >= 0 && newY >= 0 && newX < m && newY < n && room[newY][newX] == 0) {
          cleaner.x = newX;
          cleaner.y = newY;
          cleaned = true;
          break;
        }
      }

      if (!cleaned) {
        int backX = cleaner.x - cleaner.direction.dx;
        int backY = cleaner.y - cleaner.direction.dy;

        if (backX < 0 || backY < 0 || backX >= m || backY >= n || room[backY][backX] == 1) {
          break;
        }

        cleaner.x = backX;
        cleaner.y = backY;
      }
    }
    System.out.println(result);
  }
}
