import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
  BAEKJOON 14729 칠무해
  https://www.acmicpc.net/problem/14729
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Float> q = new PriorityQueue<>((o1, o2) -> Float.compare(o2, o1));

    for (int i = 0; i < n; i++) {
      Float val = Float.valueOf(br.readLine());
      q.offer(val);
      if (q.size() > 7) {
        q.poll();
      }
    }

    PriorityQueue<Float> resultQ = new PriorityQueue<>(Float::compare);
    resultQ.addAll(q);
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 7; i++) {
      result.append("%.3f".formatted(resultQ.poll())).append("\n");
    }

    System.out.printf(String.valueOf(result));
  }
}
