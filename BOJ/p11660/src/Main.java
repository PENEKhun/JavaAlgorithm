import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
      BAEKJOON 11660 구간 합 구하기 5
      https://www.acmicpc.net/problem/11660
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int size = Integer.parseInt(input[0]);
    int times = Integer.parseInt(input[1]);

    int[][] square = new int[size + 1][size + 1];
    long[][] calculated = new long[size + 1][size + 1];
    for (int i = 1; i <= size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= size; j++) {
        square[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        calculated[i][j] =
            calculated[i - 1][j] + calculated[i][j - 1] - calculated[i - 1][j - 1] + square[i][j];
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < times; i++) {
      String[] calcPoint = br.readLine().split(" ");
      int x1 = Integer.parseInt(calcPoint[0]);
      int y1 = Integer.parseInt(calcPoint[1]);

      int x2 = Integer.parseInt(calcPoint[2]);
      int y2 = Integer.parseInt(calcPoint[3]);

      long result =
          calculated[x2][y2] - calculated[x2][y1 - 1] - calculated[x1 - 1][y2] + calculated[x1 - 1][
              y1 - 1];
      bw.write(result + "\n");
    }
    bw.flush();
    bw.close();
  }
}
