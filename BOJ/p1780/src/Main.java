import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 1780 종이의 개수
  https://www.acmicpc.net/problem/1780
*/

public class Main {

  // -1, 0, 1 로 채워진 종이 수
  static int[] result = {0, 0, 0};

  static void check(int[][] paper, int startX, int startY, int size) {
    boolean allSame = true;
    int initialValue = paper[startY][startX];
    int endX = startX + size;
    int endY = startY + size;

    for (int x = startX; x < endX; x++) {
      for (int y = startY; y < endY; y++) {
        if (paper[y][x] != initialValue) {
          allSame = false;
          break;
        }
      }

      if (!allSame) {
        break;
      }
    }

    if (allSame) {
      switch (initialValue) {
        case -1: {
          ++result[0];
          break;
        }
        case 0: {
          ++result[1];
          break;
        }
        case 1: {
          ++result[2];
          break;
        }
      }

      return;
    } else {
      if (size / 3 < 1) {
        return;
      }

      if (size == 1) {
        return;
      }

      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          check(paper, startX + (size / 3) * i, startY + (size / 3) * j, size / 3);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] paper = new int[n][n];
    for (int i = 0; i < n; i++) {
      paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    check(paper, 0, 0, n);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    sb.append(result[0]).append("\n").append(result[1]).append("\n").append(result[2]).append("\n");
    bw.write(String.valueOf(sb));
    bw.flush();
  }
}