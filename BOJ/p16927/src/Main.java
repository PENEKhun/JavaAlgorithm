import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 16927 배열 돌리기 2
  https://www.acmicpc.net/problem/16927
*/

public class Main {

  static boolean[][] visited;
  static int[][] matrix;

  // 배열의 특정 층을 돌리는 함수
  public static void rotateLayer(int startY, int startX, int prevValue, int[] direction, int minY, int minX,
      int maxY, int maxX) {
    int currentY = startY;
    int currentX = startX;

    if (visited[currentY][currentX]) {
      return;
    }

    visited[currentY][currentX] = true;
    int temp = matrix[currentY][currentX];
    matrix[currentY][currentX] = prevValue;

    int nextY = currentY + direction[0];
    int nextX = currentX + direction[1];

    // 방향 변경 필요성 확인
    if (nextY < minY || nextY >= maxY || nextX < minX || nextX >= maxX) {
      direction = getNextDirection(direction);
      nextY = currentY + direction[0];
      nextX = currentX + direction[1];
    }

    rotateLayer(nextY, nextX, temp, direction, minY, minX, maxY, maxX);
  }

  // 다음 방향을 반환하는 함수
  private static int[] getNextDirection(int[] currentDirection) {
    if (Arrays.equals(currentDirection, new int[] {1, 0})) {
      return new int[] {0, 1};
    }
    if (Arrays.equals(currentDirection, new int[] {0, 1})) {
      return new int[] {-1, 0};
    }
    if (Arrays.equals(currentDirection, new int[] {-1, 0})) {
      return new int[] {0, -1};
    }
    return new int[] {1, 0};
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int n = input[0];
    int m = input[1];
    int rotations = input[2];

    matrix = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
      int perimeter = 2 * (n - 2 * layer) + 2 * (m - 2 * layer) - 4;
      if (perimeter == 0) {
        continue;
      }

      int actualRotations = rotations % perimeter;
      for (int i = 0; i < actualRotations; i++) {
        rotateLayer(layer, layer, matrix[layer][layer + 1], new int[] {1, 0}, layer, layer, n - layer,
            m - layer);
        visited = new boolean[n][m];
      }
    }

    for (int[] row : matrix) {
      System.out.println(Arrays.stream(row).mapToObj(String::valueOf).reduce((a, b) -> a + " " + b).get());
    }
  }
}