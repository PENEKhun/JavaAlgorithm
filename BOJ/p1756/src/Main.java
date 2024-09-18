import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 1756 피자 굽기
  https://www.acmicpc.net/problem/1756
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int D = Integer.parseInt(inputs[0]); // 오픈 깊이
    int N = Integer.parseInt(inputs[1]); // 피자 반죽 개수
    int[] oven = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] pizza = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    for (int i = 1; i < D; i++) {
      oven[i] = Math.min(oven[i - 1], oven[i]);
    }

    int ovenIdx = D - 1;
    int pizzaIdx = 0;
    int result = 0;
    while (pizzaIdx <= N - 1 && ovenIdx >= 0) {
      // 오븐에 피자가 들어가면
      if (oven[ovenIdx] >= pizza[pizzaIdx]) {
        pizzaIdx++;
        result++;
      }
      ovenIdx--;
    }

    if (result == N) {
      System.out.println(ovenIdx + 2);
    } else {
      System.out.println(0);
    }
  }
}
