import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  static int n, m;
  static ArrayList<ArrayList<Bus>> buses;
  static int[] memo;
  static boolean[] visited;

  public static class Bus implements Comparable<Bus> {
    int dest;
    int fee;

    public Bus(int dest, int fee) {
      this.dest = dest;
      this.fee = fee;
    }

    @Override
    public int compareTo(Bus o) {
      return this.fee - o.fee;
    }
  }

  public static void stra(int src) {
    PriorityQueue<Bus> pq = new PriorityQueue<>();
    pq.offer(new Bus(src, 0));
    memo[src] = 0;

    while (!pq.isEmpty()) {
      Bus current = pq.poll();
      int dest = current.dest;

      if (visited[dest]) continue;
      visited[dest] = true; // 방문 처리

      for (Bus bus : buses.get(dest)) {
        if (memo[bus.dest] > memo[dest] + bus.fee) {
          memo[bus.dest] = memo[dest] + bus.fee;
          pq.offer(new Bus(bus.dest, memo[bus.dest]));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 도시의 수
    m = Integer.parseInt(br.readLine()); // 버스의 수
    memo = new int[n + 1];
    visited = new boolean[n + 1];
    buses = new ArrayList<>();

    Arrays.fill(memo, Integer.MAX_VALUE);

    for (int i = 0; i <= n; i++) {
      buses.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      buses.get(input[0]).add(new Bus(input[1], input[2]));
    }

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    stra(input[0]);

    System.out.println(memo[input[1]]);
  }
}
