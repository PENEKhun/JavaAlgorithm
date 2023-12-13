import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10026 적록색약
    url : https://www.acmicpc.net/problem/10026
*/

public class Main {

  static int result = 0;
  static boolean[][] visited1;
  static char[][] image;
  static int[] x = new int[]{1, 0, -1, 0};
  static int[] y = new int[]{0, 1, 0, -1};

  public static void check(int row, int col) {
    int size = image.length;

    for (int j = 0; j < 4; j++) {
      int newRow = row + x[j];
      int newCol = col + y[j];
      if (newRow < 0 || newCol < 0) {
        continue;
      }

      if (newRow < size && newCol < size && image[newRow][newCol] == image[row][col]
          && !visited1[newRow][newCol]) {
        visited1[newRow][newCol] = true;
        check(newRow, newCol);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] rgbImage = new char[n][n];
    char[][] rbImage = new char[n][n];
    visited1 = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      char[] rgb = row.toCharArray();
      char[] rb = row.replaceAll("G", "R").toCharArray();
      rgbImage[i] = rgb;
      rbImage[i] = rb;
    }

    image = rgbImage;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited1[i][j]) {
          result++;
          check(i, j);
        }
      }
    }

    int rgbCnt = result;
    result = 0;
    visited1 = new boolean[n][n];
    image = rbImage;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited1[i][j]) {
          result++;
          check(i, j);
        }
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(rgbCnt + " " + result + "\n");
    bw.flush();

    bw.close();
    br.close();
  }
}
