import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
      BAEKJOON 11052 카드 구매하기
      https://www.acmicpc.net/problem/11052
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    for (int i = 1; i < n; i++) {
      for (int k = 0; k < i; k++) {
        for (int q = 0; q < i; q++) {
          if (k + q == i - 1) {
            prices[i] = Math.max(prices[i], prices[k] + prices[q]);
          }
        }
      }
    }

    System.out.println(prices[n - 1]);
  }
}

