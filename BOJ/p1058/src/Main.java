import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 1058 친구
  https://www.acmicpc.net/problem/1058
*/

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] result = new int[N + 1];
    boolean[][] isFriend = new boolean[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      String[] input = br.readLine().split("");
      for (int k = 0; k < input.length; k++) {
        if (input[k].equals("Y")) {
          isFriend[i][k + 1] = true;
          isFriend[k + 1][i] = true;
        }
      }
    }

    boolean[][] visited = new boolean[N + 1][N + 1];
    for (int goThrough = 1; goThrough <= N; goThrough++) {
      for (int src = 1; src <= N; src++) {
        for (int dest = 1; dest <= N; dest++) {
          if (src == dest) {
            continue;
          }

          if (isFriend[src][dest] && !visited[src][dest]) {
            result[src]++;
            visited[src][dest] = true;
          }

          if (isFriend[src][goThrough] && isFriend[goThrough][dest] && !visited[src][dest]) {
            visited[src][dest] = true;
            result[src]++;
          }
        }
      }
    }

    System.out.println(Arrays.stream(result).max().getAsInt());
  }
}
