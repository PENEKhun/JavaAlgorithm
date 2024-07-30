import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 15655 N과 M (6)
  https://www.acmicpc.net/problem/15655
*/

public class Main {
  static int n, m;
  static int[] arr;
  static boolean[] picked;
  static StringBuilder result = new StringBuilder();
  static StringBuilder temp = new StringBuilder();

  static void dfs(int idx, int depth) {

    if (depth == m) {
      result.append(temp).append("\n");
      return;
    }

    for (int i = idx; i < n; i++) {
      if (picked[i]) {
        continue;
      }

      picked[i] = true;
      int memo = temp.length();
      temp.append(arr[i]).append(" ");
      dfs(i + 1, depth + 1);
      temp.setLength(memo);
      picked[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    n = Integer.parseInt(NM[0]); // 숫자 개수
    m = Integer.parseInt(NM[1]); // 뽑아야되는거
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    picked = new boolean[n];

    Arrays.sort(arr);
    dfs(0, 0);
    System.out.print(result);
  }
}
