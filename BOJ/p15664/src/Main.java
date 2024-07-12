import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 15664 N과 M (10)
  https://www.acmicpc.net/problem/15664
*/

public class Main {

  static int[] numbers, pick;
  static int toPick, numberCnt;
  static StringBuilder result = new StringBuilder();
  static boolean[] visited;

  static void dfs(int start, int depth) {
    if (depth == toPick) {
      StringBuilder data = new StringBuilder();
      for (int i : pick) {
        data.append(i).append(" ");
      }
      result.append(data).append("\n");
      return;
    }

    int before = -1;
    for (int i = start; i < numberCnt; i++) {
      if (visited[i] || before == numbers[i]) {
        continue;
      }

      before = numbers[i];
      visited[i] = true;
      pick[depth] = numbers[i];
      dfs(i, depth + 1);
      visited[i] = false;
    }
  }

public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  String[] input = br.readLine().split(" ");
  numberCnt = Integer.parseInt(input[0]);
  toPick = Integer.parseInt(input[1]);
  numbers = Arrays.stream(br.readLine().split(" "))
      .mapToInt(Integer::valueOf)
      .sorted().toArray();
  visited = new boolean[numberCnt];
  pick = new int[toPick];

  dfs(0, 0);
  bw.write(String.valueOf(result));
  bw.flush();
}
}