import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 3190 뱀
  https://www.acmicpc.net/problem/3190
*/

public class Main {
  static int boardSize;
  static boolean[][] snakeMap;

  public static class Snake {
    Head head;

    public Snake(Head head) {
      this.head = head;
    }

    public void turn(char C) {
      if (C == 'L') { // 왼쪽 90도
        this.head.direction = switch (this.head.direction) {
          case RIGHT -> Direction.UP;
          case UP -> Direction.LEFT;
          case LEFT -> Direction.DOWN;
          case DOWN -> Direction.RIGHT;
        };
      } else {
        this.head.direction = switch (this.head.direction) {
          case RIGHT -> Direction.DOWN;
          case DOWN -> Direction.LEFT;
          case LEFT -> Direction.UP;
          case UP -> Direction.RIGHT;
        };
      }
    }

    public boolean goAble() {
      int nextX = head.x + head.direction.dx;
      int nextY = head.y + head.direction.dy;
      return (nextX >= 0 && nextX < boardSize && nextY >= 0 && nextY < boardSize &&
              !snakeMap[nextY][nextX]);
    }

    public void goForward() {
      head.x += head.direction.dx;
      head.y += head.direction.dy;
    }
  }

  public static class Head {
    int x;
    int y;
    Direction direction;

    public Head(int x, int y) {
      this.x = x;
      this.y = y;
      this.direction = Direction.RIGHT;
    }
  }

  public enum Direction {
    RIGHT(1, 0),
    DOWN(0, 1),
    UP(0, -1),
    LEFT(-1, 0);

    int dx;
    int dy;

    Direction(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }
  }

  public static class SnakeHistory {
    Integer x;
    Integer y;

    public SnakeHistory(Integer x, Integer y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boardSize = Integer.parseInt(br.readLine());
    int appleCount = Integer.parseInt(br.readLine());
    snakeMap = new boolean[boardSize][boardSize];
    Queue<SnakeHistory> moveHistory = new LinkedList<>();

    boolean[][] appleMap = new boolean[boardSize][boardSize];
    for (int i = 0; i < appleCount; i++) {
      String[] input = br.readLine().split(" ");
      appleMap[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = true;
    }

    int turnCount = Integer.parseInt(br.readLine());
    // idx초 끝난 뒤에 ......  L : 왼쪽으로 90도 회전, D 오른쪽으로 90도 회전
    Character[] events = new Character[10_001];
    for (int i = 0; i < turnCount; i++) {
      String[] input = br.readLine().split(" ");
      events[Integer.parseInt(input[0])] = input[1].charAt(0);
    }

    int duration = 0;
    Snake snake = new Snake(new Head(0, 0));
    snakeMap[0][0] = true;
    while (snake.goAble()) {
      duration++;

      moveHistory.add(new SnakeHistory(snake.head.x, snake.head.y));
      snake.goForward();
      snakeMap[snake.head.y][snake.head.x] = true;

      if (appleMap[snake.head.y][snake.head.x]) {
        // 사과 처리
        appleMap[snake.head.y][snake.head.x] = false;
      } else {
        // 사과가 없을 때
        if (moveHistory.isEmpty()) {
          break;
        }

        SnakeHistory toRemove = moveHistory.poll();
        snakeMap[toRemove.y][toRemove.x] = false;
      }

      if (events[duration] != null) {
        snake.turn(events[duration]);
      }
    }

    System.out.println(duration + 1);
  }
}
