import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 1238 파티
  https://www.acmicpc.net/problem/1238
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int x = Integer.parseInt(input[2]);

    int[][] distance = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
      distance[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      String[] line = br.readLine().split(" ");
      int start = Integer.parseInt(line[0]);
      int end = Integer.parseInt(line[1]);
      int time = Integer.parseInt(line[2]);
      distance[start][end] = time;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
            distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
          }
        }
      }
    }

    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      if (distance[i][x] != Integer.MAX_VALUE && distance[x][i] != Integer.MAX_VALUE) {
        result = Math.max(result, distance[i][x] + distance[x][i]);
      }
    }

    System.out.println(result);
  }
}
