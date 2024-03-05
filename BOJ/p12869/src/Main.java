import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 12869 뮤탈리스크
  https://www.acmicpc.net/problem/12869
*/

public class Main {

  static int[][][] dp = new int[61][61][61];
  static int[][] damagePerTime = {
      {-9, -3, -1},
      {-9, -1, -3},
      {-3, -9, -1},
      {-1, -9, -3},
      {-3, -1, -9},
      {-1, -3, -9},
  };

  static void dfs(int[] scv, int cnt) {
    if (dp[0][0][0] != 0 && dp[0][0][0] <= cnt) {
      return;
    }

    if (dp[scv[0]][scv[1]][scv[2]] != 0 && dp[scv[0]][scv[1]][scv[2]] <= cnt) {
      return;
    }

    dp[scv[0]][scv[1]][scv[2]] = cnt;
    if (scv[0] == 0 && scv[1] == 0 && scv[2] == 0) {
      return;
    }

    for (int[] damage : damagePerTime) {
      int[] newScv = scv.clone();

      // 데미지 계산
      for (int j = 0; j < newScv.length; j++) {
        newScv[j] = Math.max(newScv[j] + damage[j], 0);
      }

      dfs(newScv, cnt + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine(); // temp
    int[] scv = new int[3];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < input.length; i++) {
      scv[i] = Integer.parseInt(input[i]);
    }

    dfs(scv, 0);

    System.out.println(dp[0][0][0]);
  }
}