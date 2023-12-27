import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    BAEKJOON #1012 유기농 배추
    https://www.acmicpc.net/problem/1012
*/

public class Main {

  static boolean[][] bat;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static void dfs(int sero, int garo) {
    bat[sero][garo] = true;
    visited[sero][garo] = true;

    for (int i = 0; i < 4; i++) {

      int newSero = dy[i] + sero;
      int newGaro = dx[i] + garo;

      if (newSero < 0 || newSero > bat.length - 1) {
        continue;
      }

      if (newGaro < 0 || newGaro > bat[0].length - 1) {
        continue;
      }

      if (!visited[newSero][newGaro] && bat[newSero][newGaro]) {
        dfs(newSero, newGaro);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < testCase; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int garo = input[0];
      int sero = input[1];
      int baechu = input[2];

      bat = new boolean[sero][garo];
      visited = new boolean[sero][garo];

      // init baechu
      for (int i1 = 0; i1 < baechu; i1++) {
        int[] bachuPosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        bat[bachuPosition[1]][bachuPosition[0]] = true;
      }

      int count = 0;
      for (int row = 0; row < sero; row++) {
        for (int len = 0; len < garo; len++) {
          if (!visited[row][len] && bat[row][len]) {
            count++;
            dfs(row, len);
          }
        }
      }

      bw.write(count + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
