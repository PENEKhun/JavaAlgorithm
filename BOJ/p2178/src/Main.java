import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2178 미로 탐색
    url : https://www.acmicpc.net/problem/2178
*/

public class Main {

  // int[][] visited
  static ArrayList<Integer> result = new ArrayList<>();
  static int[][] maze;
  static int colSize;
  static int rowSize;
  static int[] rowSet = new int[]{0, 0, -1, 1}; // 상하좌우
  static int[] colSet = new int[]{1, -1, 0, 0}; // 상하좌우

  public static void lego(int col, int row, int[][] visited) {
    if (col == colSize - 1 && row == rowSize - 1) {
      result.add(visited.length);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int newRow = row + rowSet[i];
      int newCol = col + colSet[i];
      if (newCol < 0 || newRow < 0) {
        continue;
      }

      if (newCol >= colSize || newRow >= rowSize) {
        continue;
      }

      if (maze[newCol][newRow] == 1) {
        boolean isVisited = false;
        int[][] newVisited = new int[visited.length + 1][2];
        int[] nextPoint = new int[]{newCol, newRow};
        for (int i1 = 1; i1 < visited.length; i1++) {
          if (visited[i1][0] == nextPoint[0] && visited[i1][1] == nextPoint[1]) {
            isVisited = true;
            break;
          }
          newVisited[i1] = visited[i1]; // copy
        }

        if (!isVisited) {
          newVisited[visited.length] = nextPoint;
          lego(newCol, newRow, newVisited);
        }
      }
    }
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

    int[][] visited = new int[1][2];
    lego(0, 0, visited);

    int min = (int) result.stream().sorted().toArray()[0];
    bw.write(min + "\n");
    bw.flush();
  }
}
