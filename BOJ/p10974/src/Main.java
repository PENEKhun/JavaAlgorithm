import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 10974 모든 순열
  https://www.acmicpc.net/problem/10974
*/

public class Main {
  static boolean[] visited;
  static StringBuilder result = new StringBuilder();

  static void dfs(int[] temp, int depth, int N) {
    if (depth == N) {
      for (int i : temp) {
        result.append(i).append(" ");
      }
      result.append("\n");
      return;
    }

    for (int k = 0; k < N; k++) {
      if (!visited[k]) {
        visited[k] = true;
        temp[depth] = k + 1;
        dfs(temp, depth + 1, N);
        visited[k] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    visited = new boolean[N];

    dfs(new int[N], 0, N);
    System.out.println(result);
  }
}
