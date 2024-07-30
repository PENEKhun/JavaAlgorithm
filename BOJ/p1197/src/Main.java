import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
  BAEKJOON 1197 최소 스패닝 트리
  https://www.acmicpc.net/problem/1197
*/

public class Main {

  public static class Line {

    public int src;
    public int dest;
    public int weight;

    public Line(int src, int dest, int weight) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] input = br.readLine().split(" ");
    int v = Integer.parseInt(input[0]); // 정점의 개수
    int e = Integer.parseInt(input[1]); // 간선의 개수
    PriorityQueue<Line> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
    for (int i = 0; i < e; i++) {
      String[] line = br.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      int weight = Integer.parseInt(line[2]);
      q.add(new Line(a, b, weight));
    }

    boolean[] conn = new boolean[100_101];
    int cnt = 0;
    int sum = 0;
    while (!q.isEmpty()) {
      Line line = q.poll();
      if (conn[line.src] || conn[line.dest]) {
        continue;
      }
      conn[line.src] = true;

      cnt++;
      if (cnt == v) {
        break;
      }

      sum += line.weight;
    }

    bw.write(sum + "\n");
    bw.flush();
  }
}