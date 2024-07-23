import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2012 등수 매기기
  https://www.acmicpc.net/problem/2012
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] predict = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      predict[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(predict);
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += Math.abs(predict[i] - i);
    }

    System.out.println(sum);
  }
}
