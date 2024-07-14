import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 15665 N과 M (11)
  https://www.acmicpc.net/problem/15665
*/

public class Main {
  static int n, m;
  static int[] numbers;
  static StringBuilder sb = new StringBuilder();

  static void dfs(int depth, StringBuilder memo) {
    if (depth == m) {
      sb.append(memo).append("\n");
      return;
    }

    for (int number : numbers) {
      int mem = memo.length();
      memo.append(number).append(" ");
      dfs(depth + 1, memo);
      memo.setLength(mem);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
    Arrays.sort(numbers);

    dfs(0, new StringBuilder());

    bw.write(String.valueOf(sb));
    bw.flush();
  }
}