import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
  BAEKJOON 1753 최단경로
  https://www.acmicpc.net/problem/1753
*/

public class Main {

  static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
  static int[] memo;
  static class Edge implements Comparable<Edge> {

    public int to;
    public int weight;

    public Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

  public static String dijstra(int start) {
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[start] = 0;
    queue.offer(new Edge(start, 0));

    while (!queue.isEmpty()) {
      Edge edge = queue.poll();
      int from = edge.to;

      for (Edge next : edges.get(edge.to)) {
        if (memo[next.to] > memo[from] + next.weight) {
          memo[next.to] = memo[from] + next.weight;
          queue.offer(new Edge(next.to, memo[next.to]));
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 1; i < memo.length; i++) {
      if (memo[i] == Integer.MAX_VALUE) {
        result.append("INF\n");
      } else {
        result.append(memo[i]).append("\n");
      }
    }

    return String.valueOf(result);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int v = Integer.parseInt(input[0]); // 정점의 개수
    int e = Integer.parseInt(input[1]); // 간선의 개수
    int start = Integer.parseInt(br.readLine());

    // init
    for (int i = 0; i <= v + 1; i++) {
      edges.add(new ArrayList<>());
    }
    memo = new int[v + 1];

    for (int i = 0; i < e; i++) {
      input = br.readLine().split(" ");
      edges.get(Integer.parseInt(input[0]))
          .add(new Edge(
              Integer.parseInt(input[1]),
              Integer.parseInt(input[2])));
    }

    String result = dijstra(start);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(result);
    bw.flush();
  }
}