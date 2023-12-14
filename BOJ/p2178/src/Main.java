import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int[][] maze;
  static int colSize;
  static int rowSize;
  static int[] rowSet = new int[]{0, 0, -1, 1}; // 상하좌우
  static int[] colSet = new int[]{1, -1, 0, 0}; // 상하좌우

  public static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[colSize][rowSize];

    queue.offer(new int[]{0, 0, 1});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int col = current[0];
      int row = current[1];
      int distance = current[2];

      if (col == colSize - 1 && row == rowSize - 1) {
        return distance;
      }

      for (int i = 0; i < 4; i++) {
        int newCol = col + colSet[i];
        int newRow = row + rowSet[i];

        if (newCol >= 0 && newRow >= 0 && newCol < colSize && newRow < rowSize
            && maze[newCol][newRow] == 1 && !visited[newCol][newRow]) {
          queue.offer(new int[]{newCol, newRow, distance + 1});
          visited[newCol][newRow] = true;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    colSize = Integer.parseInt(input[0]);
    rowSize = Integer.parseInt(input[1]);

    maze = new int[colSize][rowSize];
    for (int i = 0; i < colSize; i++) {
      maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }

    int result = bfs();

    bw.write(result + "\n");
    bw.flush();
  }
}
