import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;

/*
  BAEKJOON 15663 N과 M (9)
  https://www.acmicpc.net/problem/15663
*/

public class Main {

  static int n, m;
  static int[] num;
  static boolean[] visited;
  static LinkedHashSet<String> result = new LinkedHashSet<>();

  public static void find(int cnt, StringBuilder memory) {
    if (cnt == m) {
      result.add(String.valueOf(memory));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        StringBuilder newSb = new StringBuilder(memory.isEmpty() ? "" : memory + " ");
        find(cnt + 1, newSb.append(num[i]));
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    num = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .sorted()
        .toArray();
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      visited[i] = true;
      find(1, new StringBuilder().append(num[i]));
      visited[i] = false;
    }

    for (String s : result) {
      bw.write(s + "\n");
    }
    bw.flush();
    bw.close();
  }
}
