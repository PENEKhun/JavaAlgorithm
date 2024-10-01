import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 11403 경로 찾기
  https://www.acmicpc.net/problem/11403
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Boolean[][] G = new Boolean[n][];
    for (int i = 0; i < n; i++) {
      G[i] = Arrays.stream(br.readLine().split(" ")).map(o -> o.equals("1")).toArray(Boolean[]::new);
    }

    for (int goThrouth = 0; goThrouth < n; goThrouth++) {
      for (int src = 0; src < n; src++) {
        for (int dest = 0; dest < n; dest++) {
          if (goThrouth == src || goThrouth == dest) {
            continue;
          }

          if (G[src][goThrouth] && G[goThrouth][dest]) {
            G[src][dest] = true;
          }
        }
      }
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result.append(G[i][j] ? "1" : "0").append(" ");
      }
      result.append("\n");
    }

    System.out.print(result);
  }
}
