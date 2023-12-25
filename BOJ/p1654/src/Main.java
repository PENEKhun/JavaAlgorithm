import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    BAEKJOON #1654 랜선 자르기
    https://www.acmicpc.net/problem/1654
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int K = input[0];
    int N = input[1];
    long max = -1;
    int[] item = new int[K];
    for (int i = 0; i < K; i++) {
      int length = Integer.parseInt(br.readLine());
      item[i] = length;
      if (max < length) {
        max = length;
      }
    }

    long min = 1;
    long mid = 0;

    while (min <= max) {
      mid = (min + max) / 2;

      long count = 0;
      for (long len : item) {
        count += len / mid;
      }

      if (count < N) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    System.out.println(max);
  }
}
