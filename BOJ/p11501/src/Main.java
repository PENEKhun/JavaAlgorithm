import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 11501 주식
  https://www.acmicpc.net/problem/11501
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    for (int temp = 0; temp < testCase; temp++) {
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");
      int[] price = new int[n + 1];
      for (int i = 0; i < input.length; i++) {
        price[i + 1] = Integer.parseInt(input[i]);
      }

      int[] overPriceMaxAfter = new int[n + 1];
      overPriceMaxAfter[n] = price[n];

      for (int i = n - 1; i >= 1; i--) {
        overPriceMaxAfter[i] = Math.max(overPriceMaxAfter[i + 1], price[i]);
      }

      long earn = 0;
      for (int i = 1; i <= n; i++) {
        if (overPriceMaxAfter[i] > price[i]) {
          earn += (overPriceMaxAfter[i] - price[i]);
        }
      }
      result.append(earn).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();
  }
}
