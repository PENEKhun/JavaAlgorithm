import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 2563 색종이
  https://www.acmicpc.net/problem/2563
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    boolean[][] papers = new boolean[100][100];
    for (int i = 0; i < n; i++) {
      String[] XY = br.readLine().split(" ");
      int x = Integer.parseInt(XY[0]);
      int y = Integer.parseInt(XY[1]);

      for (int width = x; width < x + 10; width++) {
        for (int height = y; height < y + 10; height++) {
          papers[height][width] = true;
        }
      }
    }

    int result = 0;
    for (int i = 0; i < 100; i++) {
      for (int k = 0; k < 100; k++) {
        if (papers[i][k]) {
          result++;
        }
      }
    }

    System.out.println(result);
  }
}
