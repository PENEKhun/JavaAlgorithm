import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 10451 순열 사이클
  https://www.acmicpc.net/problem/10451
*/

public class Main {
  static boolean[] visited;
  static int[] map;

  static void dfs(int k) {
    int next = map[k];
    if (!visited[next]) {
      visited[next] = true;
      dfs(next);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < testCase; i++) {
      int n = Integer.parseInt(br.readLine());
      map = new int[n + 1];

      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int k = 0; k < arr.length; k++) {
        map[k + 1] = arr[k];
      }

      int cycle = 0;
      visited = new boolean[n + 1];
      for (int k = 1; k <= n; k++) {
        if (!visited[k]) {
          cycle++;
          dfs(k);
        }
      }

      result.append(cycle).append("\n");
    }

    System.out.println(result);
  }
}
