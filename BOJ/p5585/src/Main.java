import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 5585 거스름돈
  https://www.acmicpc.net/problem/5585
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = 1000 - Integer.parseInt(br.readLine());
    int result = 0;
    int[] coins = {500, 100, 50, 10, 5, 1};

    for (int coin : coins) {
      while (n / coin > 0) {
        result += n / coin;
        n %= coin;
      }
    }

    System.out.println(result);
  }
}