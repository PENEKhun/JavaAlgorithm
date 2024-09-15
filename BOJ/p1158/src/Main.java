import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 1158 요세푸스 문제
  https://www.acmicpc.net/problem/1158
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    int[] people = new int[N];
    for (int i = 0; i < N; i++) {
      people[i] = i + 1;
    }

    String[] result = new String[N];

    int killed = 0;
    int idx = 0;
    int cnt = 1;
    while (killed != N) {
      if (idx >= N) {
        idx %= N;
      }

      if (people[idx] == 0) {
        idx++;
      } else {
        if (cnt != K) {
          cnt++;
          idx++;
          continue;
        }

        result[killed] = String.valueOf(people[idx]);
        people[idx] = 0;
        cnt = 1;
        killed++;
      }
    }

    System.out.println(
        "<" + Arrays.stream(result).reduce((a, b) -> a + ", " + b).get() + ">"
    );
  }
}
