/*
    BAEKJOON 11724 연결 요소의 개수
    https://www.acmicpc.net/problem/11724
*/

import java.util.Scanner;

public class Main {

  static boolean[][] graph;
  static boolean[] noAlone;

  static void dfs(int u, int v) {
    graph[u][v] = false;
    noAlone[u] = true;
    for (int i = 1; i < graph.length; i++) {
      if (graph[v][i]) {
        dfs(v, i);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt(); // 정점
    int M = scanner.nextInt(); // 간선

    graph = new boolean[N+1][N+1];
    for (int i = 0; i < M; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();
      graph[u][v] = true;
      graph[v][u] = true;
    }

    int result = 0;
      /*
      https://www.acmicpc.net/board/view/47059
      이어지는 간선이 없다고 정점이 없는게 아닙니다.
       */
    noAlone = new boolean[N+1];
    for (int i = 1; i <= N; i++) {
      for (int k = 1; k <= N; k++) {
        if (graph[i][k]) {
          result++;
          dfs(i, k);
          dfs(k, i);
        }
      }
    }

    for (int i = 1; i < noAlone.length; i++) {
      if (!noAlone[i])
        result++;
    }

    System.out.println(result);
  }
}
