import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 11404 플로이드
  https://www.acmicpc.net/problem/11404
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cityCnt = Integer.parseInt(br.readLine());
    int busCnt = Integer.parseInt(br.readLine());

    int[][] result = new int[cityCnt + 1][cityCnt + 1];
    for (int i = 0; i <= cityCnt; i++) {
      Arrays.fill(result[i], Integer.MAX_VALUE);
    }

    for (int i = 0; i < busCnt; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      result[input[0]][input[1]] = Math.min(result[input[0]][input[1]], input[2]);
    }

    for (int i = 1; i <= cityCnt; i++) {
      result[i][i] = 0;
    }

    for (int goThrough = 1; goThrough <= cityCnt; goThrough++) {
      for (int start = 1; start <= cityCnt; start++) {
        for (int end = 1; end <= cityCnt; end++) {

          if (result[start][goThrough] == Integer.MAX_VALUE) {
            continue;
          }

          if (result[goThrough][end] == Integer.MAX_VALUE) {
            continue;
          }

          result[start][end] =
              Math.min(result[start][end],
                  result[start][goThrough] + result[goThrough][end]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= cityCnt; i++) {
      for (int k = 1; k <= cityCnt; k++) {
        if (i == k) {
          sb.append("0 ");
        } else if (result[i][k] == Integer.MAX_VALUE) {
          sb.append("0 ");
        } else {
          sb.append(result[i][k]).append(" ");
        }
      }

      sb.append("\n");
    }

    System.out.printf(String.valueOf(sb));
  }
}