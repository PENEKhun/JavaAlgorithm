import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    BAEKJOON 2630 색종이 만들기
    https://www.acmicpc.net/problem/2630
*/

public class Main {
  static int truePaper = 0;
  static int falsePaper = 0;
  static boolean[][] arr;

  public static void sol(int startX, int endX, int startY, int endY) {
    boolean initValue = arr[startY][startX];

    if (startX + 1 == endX || startY + 1 == endY) {
      if (initValue) {
        truePaper++;
      } else {
        falsePaper++;
      }

      return;
    }

    boolean flag = false;
    for (int y = startY; y < endY; y++) {
      for (int x = startX; x < endX; x++) {
        if (arr[y][x] != initValue) {
          int n = arr.length;
          int halfX = (startX + endX) / 2;
          int halfY = (startY + endY) / 2;
          // 1사
          sol(startX, halfX, startY, halfY);

          // 2사
          sol(halfX, endX, startY, halfY);

          // 3사
          sol(startX, halfX, halfY, endY);

          // 4사
          sol(halfX, endX, halfY, endY);

          flag = true;
          break;
        }
      }
      if (flag)
        break;
    }

    if (!flag) {
      if (initValue) {
        truePaper++;
      } else {
        falsePaper++;
      }
    }
  }



  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      for (int i1 = 0; i1 < line.length; i1++) {
        arr[i][i1] = (line[i1].equals("1"));
      }
    }

    sol(0, n, 0, n);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(falsePaper + "\n" + truePaper + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
