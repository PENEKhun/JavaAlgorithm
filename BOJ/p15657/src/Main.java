import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 15657 N과 M (8)
  https://www.acmicpc.net/problem/15657
*/

public class Main {

  static int[] number;
  static int n, m;
  static StringBuilder result = new StringBuilder();

  public static void find(int idx, StringBuilder sb, int size) {
    if (size == m) {
      result.append(sb).append("\n");
      return;
    }

    for (int i = idx; i < n; i++) {
      find(i, new StringBuilder(sb).append(" ").append(number[i]), size + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(number);
    for (int i = 0; i < n; i++) {
      find(i, new StringBuilder().append(number[i]), 1);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();
  }
}