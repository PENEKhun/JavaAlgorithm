import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 15656 N과 M (7)
  https://www.acmicpc.net/problem/15656
*/

public class Main {
  static int n, m;
  static int[] numbers;
  static StringBuilder result = new StringBuilder();

  static void dfs(int depth, StringBuilder memo) {
    if (depth == m) {
      result.append(memo).append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      int len = memo.length();
      memo.append(numbers[i]).append(" ");
      dfs(depth + 1, memo);
      memo.setLength(len);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
    Arrays.sort(numbers);

    dfs(0, new StringBuilder());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();
  }
}