import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
  BAEKJOON 1504 특정한 최단 경로
  https://www.acmicpc.net/problem/1504
*/

public class Main {
  static ArrayList<ArrayList<Edge>> edges;
  static int n;

  public static class Edge {
    public int to;
    public int weight;

    public Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public static int stra(int start, int end) {
    int[] memo = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      memo[i] = Integer.MAX_VALUE;
    }
    memo[start] = 0;

    PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

    q.add(new Edge(start, 0));

    while (!q.isEmpty()) {
      Edge edge = q.poll();
      int from = edge.to;

      for (Edge next : edges.get(from)) {
        if (memo[next.to] > next.weight + memo[from]) {
          memo[next.to] = next.weight + memo[from];
          q.add(next);
        }
      }
    }

    return memo[end];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    int e = Integer.parseInt(input[1]);
    edges = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      edges.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      input = br.readLine().split(" ");
      int from = Integer.parseInt(input[0]);
      int to = Integer.parseInt(input[1]);
      int weight = Integer.parseInt(input[2]);
      edges.get(from).add(new Edge(to, weight));
      edges.get(to).add(new Edge(from, weight));
    }

    input = br.readLine().split(" ");
    int[] v = new int[] {0, Integer.parseInt(input[0]), Integer.parseInt(input[1])};
    int part1 = stra(1, v[1]);
    int part2 = stra(v[1], v[2]);
    int part3 = stra(v[2], n);

    int partpart1 = stra(1, v[2]);
    int partpart2 = stra(v[2], v[1]);
    int partpart3 = stra(v[1], n);

    long result1 = (long) part1 + part2 + part3;
    long result2 = (long) partpart1 + partpart2 + partpart3;
    long result = Math.min(result1, result2);

    if (result >= Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
  }
}
