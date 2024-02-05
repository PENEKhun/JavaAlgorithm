import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
      BAEKJOON 2740 행렬 곱셈
      https://www.acmicpc.net/problem/2740
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int[][] matrixA = new int[n][m];
    for (int i = 0; i < n; i++) {
      matrixA[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    input = br.readLine().split(" ");
    int M = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);
    int[][] matrixB = new int[M][K];
    for (int i = 0; i < M; i++) {
      matrixB[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    // mul Matrix. n by K
    int[][] result = new int[n][K];
    for (int i = 0; i < K; i++) {
      for (int j = 0; j < n; j++) {

        int tmp = 0;
        for (int p = 0; p < M; p++) {
          tmp += matrixA[j][p] * matrixB[p][i];
        }
        result[j][i] = tmp;
      }
    }

    for (int[] ints : result) {
      System.out.println(Arrays.stream(ints).mapToObj(Integer::toString).reduce((a, b) -> a + " " + b).get());
    }
  }
}
