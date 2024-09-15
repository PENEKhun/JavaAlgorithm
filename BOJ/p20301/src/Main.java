import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  BAEKJOON 20301 반전 요세푸스
  https://www.acmicpc.net/problem/20301
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = inputs[0]; // 총 몇명
    int K = inputs[1]; // K번째 offset kill
    int M = inputs[2]; // M명 죽일때 마다 방향전환

    List<Integer> people = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      people.add(i);
    }

    StringBuilder result = new StringBuilder();
    int killed = 0;
    int toKill = K - 1;
    int direction = 1; // right, left
    while (!people.isEmpty()) {
      while (toKill <= 0) {
        toKill += people.size();
      }

      if (toKill >= people.size()) {
        toKill %= people.size();
      }

      result.append(people.get(toKill)).append("\n");
      people.remove(toKill);
      killed++;
      if (killed == M) {
        killed = 0;
        direction *= -1;
      }

      if (direction == 1) {
        toKill += K - 1;
      } else {
        toKill -= K;
      }
    }
    System.out.print(result);
  }
}
