import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
  BAEKJOON 9205 맥주 마시면서 걸어가기
  https://www.acmicpc.net/problem/9205
*/

public class Main {
  public static class Edge {
    public int endX;
    public int endY;

    public Edge(int endX, int endY) {
      this.endX = endX;
      this.endY = endY;
    }
  }

  public static int calcDistance(int startX, int startY, int endX, int endY) {
    return Math.abs(startX - endX) + Math.abs(startY - endY);
  }

  public static String coordToString(int x, int y) {
    return x + "," + y;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    for (int testCase = 0; testCase < t; testCase++) {
      int n = Integer.parseInt(br.readLine()); // 편의점 갯수
      int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int[][] points = new int[n + 1][2];
      for (int i = 0; i < n; i++) {
        points[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }
      points[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      Queue<Edge> q = new LinkedList<>();
      Set<String> visited = new HashSet<>();
      q.add(new Edge(start[0], start[1]));
      visited.add(coordToString(start[0], start[1]));

      boolean isHappy = false;
      while (!q.isEmpty()) {
        Edge edge = q.poll();

        for (int[] point : points) {
          int newX = point[0];
          int newY = point[1];
          String coordKey = coordToString(newX, newY);

          int distance = calcDistance(edge.endX, edge.endY, newX, newY);
          if (distance > 1000) {
            continue;
          }
          if (visited.contains(coordKey)) {
            continue;
          }

          visited.add(coordKey);

          if (newX == points[n][0] && newY == points[n][1]) {
            isHappy = true;
            q.clear();
            break;
          } else {
            q.add(new Edge(newX, newY));
          }
        }
      }

      result.append(isHappy ? "happy\n" : "sad\n");
    }
    System.out.print(result);
  }
}
