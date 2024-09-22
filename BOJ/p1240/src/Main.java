import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 1240 노드사이의 거리
  https://www.acmicpc.net/problem/1240
*/

public class Main {
  static int[][] distance;
  static HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);
    distance = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int i = 1; i < N; i++) {
      String[] input = br.readLine().split(" ");
      int src = Integer.parseInt(input[0]);
      int dest = Integer.parseInt(input[1]);
      int len = Integer.parseInt(input[2]);

      distance[src][dest] = len;
      distance[dest][src] = len;
      nodes.get(src).add(dest);
      nodes.get(dest).add(src);
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      Queue<int[]> q = new LinkedList<>();
      boolean[] visited = new boolean[N + 1];
      q.add(new int[] {start, end, 0});
      visited[start] = true;
      while (!q.isEmpty()) {
        int[] poll = q.poll();
        int src = poll[0];
        int dest = poll[1];
        int nowDistance = poll[2];
        if (src == dest) {
          result.append(nowDistance).append("\n");
          break;
        }

        for (Integer next : nodes.get(src)) {
          if (visited[next]) {
            continue;
          }

          visited[next] = true;
          q.add(new int[] {next, dest, nowDistance + distance[src][next]});
        }
      }
    }

    System.out.println(result);
  }
}
