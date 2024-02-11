import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
      BAEKJOON 1932 정수 삼각형
      https://www.acmicpc.net/problem/1932
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    int[][] triangle = new int[size][size];
    for (int i = 0; i < size; i++) {
      triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int[][] dp = new int[size][size];
    dp[size - 1] = triangle[size - 1];

    for (int depth = triangle.length - 2; depth > 0; depth--) {
      for (int index = 0; index < triangle[depth].length; index++) {
        dp[depth][index] = Math.max(dp[depth + 1][index], dp[depth + 1][index + 1])
            + triangle[depth][index];
      }
    }

    int max;
    if (size == 1) {
      max = triangle[0][0];
    } else {
      max = Arrays.stream(dp[1]).max().getAsInt() + triangle[0][0];
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(max + "\n");
    bw.flush();
  }
}
