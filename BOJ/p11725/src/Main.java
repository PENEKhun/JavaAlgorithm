import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 11725 트리의 부모 찾기
  https://www.acmicpc.net/problem/11725
*/

public class Main {

  static int n;
  static ArrayList<LinkedList<Integer>> graph;
  static int[] result;
  static boolean[] visited;

  public static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      start = q.poll();
      for (Integer next : graph.get(start)) {
        if (visited[next]) {
          continue;
        }

        result[next] = start;
        visited[next] = true;
        q.add(next);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();

    // init
    for (int i = 0; i <= n; i++) {
      graph.add(new LinkedList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      graph.get(input[0]).add(input[1]);
      graph.get(input[1]).add(input[0]);
    }

    result = new int[n + 1];
    visited = new boolean[n + 1];
    bfs(1);

    StringBuilder sb = new StringBuilder();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 2; i <= n; i++) {
      sb.append(result[i]).append("\n");
    }

    bw.write(String.valueOf(sb));
    bw.flush();
  }
}