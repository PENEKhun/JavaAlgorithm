import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 1260 DFS와 BFS
  https://www.acmicpc.net/problem/1260
*/

public class Main {

  static boolean[][] graph;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void dfs(int into) {
    visited[into] = true;
    for (int i = 1; i < graph[into].length; i++) {
      if (graph[into][i] && !visited[i]) {
        sb.append(i).append(" ");
        dfs(i);
      }
    }
  }

  public static void bfs(int into) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(into);
    sb.append(into).append(" ");
    visited[into] = true;

    while (!queue.isEmpty()) {
      int dest = queue.poll();
      for (int i = 1; i < graph[into].length; i++) {
        if (graph[dest][i] && !visited[i]) {
          sb.append(i).append(" ");
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]); // 정점의 개수
    int m = Integer.parseInt(input[1]); // 간선의 개수
    int v = Integer.parseInt(input[2]); // 탐색을 시작할 정점의 번호

    graph = new boolean[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      String[] line = br.readLine().split(" ");
      int src = Integer.parseInt(line[0]);
      int dest = Integer.parseInt(line[1]);
      graph[src][dest] = true;
      graph[dest][src] = true;
    }

    sb.append(v).append(" ");
    dfs(v);
    sb.append("\n");

    visited = new boolean[n + 1];
    bfs(v);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(sb));
    bw.flush();
  }
}