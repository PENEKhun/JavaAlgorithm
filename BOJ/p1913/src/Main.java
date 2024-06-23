import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 1913 달팽이
  https://www.acmicpc.net/problem/1913
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    // 시작 지점 계산
    int x = (n / 2);
    int y = (n / 2);
    int toFind = Integer.parseInt(br.readLine());
    int[][] snail = new int[n][n];
    int[] xy = new int[2];
    int[][] dxy = new int[][] {
        // x, y
        {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    int direction = 0;
    // 돌리고 돌리고
    int number = 0;
    while (!(x == 0 && y == 0)) {
      number++;
      snail[y][x] = number;
      if (number == toFind) {
        xy[0] = x;
        xy[1] = y;
      }

      if (number == 1) {
        y -= 1;
        continue;
      }

      int nextX = x + dxy[direction][0];
      int nextY = y + dxy[direction][1];

      int turnX = x + dxy[(direction == 3) ? 0 : direction + 1][0];
      int turnY = y + dxy[(direction == 3) ? 0 : direction + 1][1];
      if (snail[turnY][turnX] == 0) {
        direction = (direction == 3) ? 0 : direction + 1;
        x = turnX;
        y = turnY;
      } else {
        x = nextX;
        y = nextY;
      }
    }

    snail[0][0] = number + 1;

    // 출력
    StringBuilder result = new StringBuilder();
    for (int[] ints : snail) {
      for (int anInt : ints) {
        result.append(anInt).append(" ");
      }
      result.append("\n");
    }
    result.append(xy[1] + 1).append(" ").append(xy[0] + 1).append("\n");
    bw.write(String.valueOf(result));
    bw.flush();
  }
}