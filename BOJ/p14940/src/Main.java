import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    BAEKJOON 14940 쉬운 최단거리
    https://www.acmicpc.net/problem/14940
*/

public class Main {

  public static boolean[][] visited;
  public static int[][] result;
  public static int[][] map;

  public static void dfs(int row, int col) {
    visited[row][col] = true;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{row, col, 0});

    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    while (!queue.isEmpty()) {
      int[] position = queue.poll();
      int distance = position[2];
      result[position[0]][position[1]] = distance;

      for (int i = 0; i < 4; i++) {
        int newRow = position[0] + dy[i];
        int newCol = position[1] + dx[i];

        if (newRow < 0 || newRow > map.length - 1) {
          continue;
        }

        if (newCol < 0 || newCol > map[0].length - 1) {
          continue;
        }

        if (!visited[newRow][newCol] && map[newRow][newCol] == 1) {
          visited[newRow][newCol] = true;
          queue.add(new int[]{newRow, newCol, distance + 1});
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int rowSize = Integer.parseInt(input[0]);
    int colSize = Integer.parseInt(input[1]);

    map = new int[rowSize][colSize];
    visited = new boolean[rowSize][colSize];
    result = new int[rowSize][colSize];

    for (int i = 0; i < rowSize; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int row = 0; row < rowSize; row++) {
      for (int col = 0; col < colSize; col++) {
        if (map[row][col] == 2) {
          dfs(row, col);
          break;
        }
      }
    }

    StringBuilder toPrint = new StringBuilder();
    for (int row = 0; row < rowSize; row++) {
      for (int col = 0; col < colSize; col++) {
        int distance = result[row][col];
        if (distance == 0 && map[row][col] == 1) {
          toPrint.append("-1").append(" ");
        } else {
          toPrint.append(distance).append(" ");
        }
      }
      toPrint.append("\n");
    }

    System.out.print(toPrint);
  }
}
