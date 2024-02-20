import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/*
  BAEKJOON 15651 N과 M (3)
  https://www.acmicpc.net/problem/15651
*/

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int m;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]); // 최대
    m = Integer.parseInt(input[1]); // 길이
    arr = new int[m];
    for (int i = 0; i < m; i++) {
      arr[i] = 1;
    }

    int i = m-1;
    arr[i] = 0;
      do {

        if (arr[i] == n) {
          // 올려야 될 것 찾기
          for (int j = i - 1; j >= 0; j--) {
            if (arr[j] != n) {
              arr[j] += 1;
              Arrays.fill(arr, j + 1, m, 1);
              break;
            }
          }
        } else {
          arr[i] += 1;
        }

        sb.append(Arrays.stream(arr).mapToObj(Objects::toString).reduce((o1, o2) -> o1 + " " + o2).get())
            .append("\n");
      } while (!Arrays.stream(arr).allMatch(s -> s == n));

    System.out.print(sb);
  }
}