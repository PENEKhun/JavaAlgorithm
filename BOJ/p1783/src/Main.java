import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1783 병든 나이트
  https://www.acmicpc.net/problem/1783
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    int result;
    if (N == 1) {
      result = 1;
    } else if (N == 2) {
      result = Math.min(4, (M + 1) / 2);
    } else if (M < 7) {
      result = Math.min(4, M);
    } else {
      result = M - 7 + 5;
    }

    System.out.println(result);
  }
}
