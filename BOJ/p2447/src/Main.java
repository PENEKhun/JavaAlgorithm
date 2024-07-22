import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 2447 별 찍기 - 10
  https://www.acmicpc.net/problem/2447
*/

public class Main {
  static char[][] result;

  static void star(int x, int y, int n) {
    if (n == 1) {
      result[y][x] = '*';
      return;
    }

    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < 3; k++) {
        if (j == 1 && k == 1) {
          continue;
        } else {
          star(x + (n / 3) * j, y + (n / 3) * k, n / 3);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    result = new char[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(result[i], ' ');
    }

    star(0, 0, n);
    for (int y = 0; y < n; y++) {
      bw.write(result[y]);
      bw.newLine();
    }
    bw.flush();
  }
}
