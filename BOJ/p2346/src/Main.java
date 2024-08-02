import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2346 풍선 터뜨리기
  https://www.acmicpc.net/problem/2346
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    StringBuilder result = new StringBuilder();
    int next = 0;
    int reamin = size;
    while (reamin > 0) {
      int before = next;
      result.append(before + 1).append(" ");
      int offset = numbers[next];
      numbers[next] = 0;
      next += offset;
      reamin--;

      int toGo = Math.abs(before - next);
      int k = before;
      while (toGo != 0 && reamin != 0) {
        k += (offset > 0) ? 1 : -1;
        if (k == -1) {
          k = size - 1;
        } else if (k == size) {
          k = 0;
        }

        if (numbers[k] != 0) {
          toGo--;
        }
      }
      next = k;
    }

    System.out.println(result);
  }
}
