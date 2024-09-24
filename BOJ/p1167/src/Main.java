import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
  BAEKJOON 1167 트리의 지름
  https://www.acmicpc.net/problem/1167
*/

public class Main {
  static int n;
  static ArrayList<Edge>[] edges;
  static boolean[] visited;
  static int maxNode;
  static int maxDistance;

  static class Edge {
    int number;
    int distance;

    public Edge(int number, int distance) {
      this.number = number;
      this.distance = distance;
    }
  }

  public static void dfs(int nowNode, int nowDistance) {
    if (maxDistance < nowDistance) {
      maxNode = nowNode;
      maxDistance = nowDistance;
    }
    visited[nowNode] = true;

    for (Edge nextNode : edges[nowNode]) {
      if (!visited[nextNode.number]) {
        dfs(nextNode.number, nowDistance + nextNode.distance);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    edges = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      edges[i] = new ArrayList<>();
    }

    for (int i = 1; i <= n; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int start = input[0];
      for (int k = 1; k < input.length; k += 2) {
        if (input[k] == -1) break;
        edges[start].add(new Edge(input[k], input[k + 1]));
      }
    }

    // 가장 먼 노드 찾기
    visited = new boolean[n + 1];
    dfs(1, 0);

    // 가장 긴 지름
    visited = new boolean[n + 1];
    dfs(maxNode, 0);

    System.out.println(maxDistance);
  }
}
