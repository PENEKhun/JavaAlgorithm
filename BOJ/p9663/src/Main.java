import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 9663 N-Queen
  https://www.acmicpc.net/problem/9663
*/
public class Main {
  static int n;
  static int result;
  static boolean[] cols;
  static boolean[] d1;
  static boolean[] d2;

  static void dfs(int row) {
    if (row == n) {
      result += 1;
      return;
    }

    for (int col = 0; col < n; col++) {
      if (!cols[col] && !d1[row - col + n - 1] && !d2[row + col]) {
        cols[col] = d1[row - col + n - 1] = d2[row + col] = true;
        dfs(row + 1);
        cols[col] = d1[row - col + n - 1] = d2[row + col] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    cols = new boolean[n];
    d1 = new boolean[2 * n - 1]; //
    d2 = new boolean[2 * n - 1];
    dfs(0);
    System.out.println(result);
  }
}
