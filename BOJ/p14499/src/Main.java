import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 14499 주사위 굴리기
  https://www.acmicpc.net/problem/14499
*/

public class Main {
  static int[][] commandXY = new int[][] {
//    none, 오, 왼, 위, 아래
      {}, {1, 0}, {-1, 0}, {0, -1}, {0, 1}
  };

  static int[][] cube = new int[][] {
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0}};

  public static void go(int command) {
    int temp;
    switch (command) {
      case 1: // 동쪽
        temp = cube[1][2];
        cube[1][2] = cube[1][1];
        cube[1][1] = cube[1][0];
        cube[1][0] = cube[3][1];
        cube[3][1] = temp;
        break;
      case 2: // 서쪽
        temp = cube[1][0];
        cube[1][0] = cube[1][1];
        cube[1][1] = cube[1][2];
        cube[1][2] = cube[3][1];
        cube[3][1] = temp;
        break;
      case 3: // 북쪽
        temp = cube[0][1];
        cube[0][1] = cube[1][1];
        cube[1][1] = cube[2][1];
        cube[2][1] = cube[3][1];
        cube[3][1] = temp;
        break;
      case 4: // 남쪽
        temp = cube[3][1];
        cube[3][1] = cube[2][1];
        cube[2][1] = cube[1][1];
        cube[1][1] = cube[0][1];
        cube[0][1] = temp;
        break;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int height = Integer.parseInt(input[0]);
    int width = Integer.parseInt(input[1]);
    int y = Integer.parseInt(input[2]);
    int x = Integer.parseInt(input[3]);
    int commandLength = Integer.parseInt(input[4]);

    int[][] map = new int[height][];
    for (int i = 0; i < height; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    StringBuilder result = new StringBuilder();
    for (int command : commands) {
      int nextX = x + commandXY[command][0];
      int nextY = y + commandXY[command][1];
      if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
        continue;
      }

      go(command);
      if (map[nextY][nextX] == 0) {
        // 바닥수가 지도로 복사
        map[nextY][nextX] = cube[3][1];
      } else {
        // 지도 값이 바닥으로 감, 지도값 0
        cube[3][1] = map[nextY][nextX];
        map[nextY][nextX] = 0;
      }

      result.append(cube[1][1]).append("\n");
      x = nextX;
      y = nextY;
    }
    System.out.printf(String.valueOf(result));
  }
}
