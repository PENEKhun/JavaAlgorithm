import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    BAEKJOON 7576 토마토
    https://www.acmicpc.net/problem/7576
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int col = Integer.parseInt(input[0]);
    int row = Integer.parseInt(input[1]);
    int[][] tomatoes = new int[row][col];

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    for (int i = 0; i < row; i++) {
      tomatoes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    Queue<Position> toChange = new LinkedList<>();
    for (int y = 0; y < row; y++) {
      for (int x = 0; x < col; x++) {
        if (tomatoes[y][x] == 1) {
          toChange.add(new Position(y, x));
        }
      }
    }

    int day = 0;

    boolean[][] visited = new boolean[row][col];
    Queue<Position> newChange = new LinkedList<>();

    boolean flag = false;
    while (!toChange.isEmpty()) {
      Position now = toChange.poll();

      if (day != 0) {
        tomatoes[now.row][now.col] = 1;
      }

      for (int i = 0; i < 4; i++) {
        int newCol = now.col + dx[i];
        int newRow = now.row + dy[i];

        if (newCol < 0 || newCol > tomatoes[0].length - 1) {
          continue;
        }

        if (newRow < 0 || newRow > tomatoes.length - 1) {
          continue;
        }

        if (tomatoes[newRow][newCol] == 0 && !visited[newRow][newCol]) {
          flag = true;
          newChange.add(
              new Position(newRow, newCol)
          );
          visited[newRow][newCol] = true;
        }
      }

      if (toChange.isEmpty()) {
        toChange = newChange;
        newChange = new ArrayDeque<>();
        if (flag) {
          day++;
          flag = false;
        }
      }
    }

    for (int y = 0; y < row; y++) {
      for (int x = 0; x < col; x++) {
        if (tomatoes[y][x] == 0) {
          day = -1;
          break;
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(day + "\n");
    bw.flush();
    bw.close();
  }

  public static class Position {

    public int row;
    public int col;

    public Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
