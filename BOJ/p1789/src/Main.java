import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1789 수들의 합
  https://www.acmicpc.net/problem/1789
*/

public class Main {
  public static long gaus(long n) {
    return (n * (n + 1)) / 2;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long S = Long.parseLong(br.readLine());
    long result = 1;
    for (long i = 1; i < S; i++) {
      if (gaus(i) <= S) {
        result = i;
      } else {
        break;
      }
    }

    System.out.println(result);
  }
}
