import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
  BAEKJOON 11779 최소비용 구하기 2
  https://www.acmicpc.net/problem/11779
*/

public class Main {
  static ArrayList<ArrayList<Bus>> buses;
  static long[] minCost;
  static ArrayList<Integer> through = new ArrayList<>();

  static class Bus implements Comparable<Bus> {
    int to;
    int price;
    Bus before;
    Bus after;

    public Bus(int to, int price) {
      this.to = to;
      this.price = price;
    }

    public int compareTo(Bus o) {
      return Integer.compare(this.price, o.price);
    }
  }

  public static void calcTrough(Bus rootBus) {
    Queue<Bus> q = new LinkedList<>();
    q.add(rootBus);

    while (!q.isEmpty()) {
      Bus bus = q.poll();
      through.add(0, bus.to);
      if (bus.before != null) {
        q.add(bus.before);
      }
    }
  }

  public static void findRootBus(int start, int end, int sum) {
    for (Bus bus : buses.get(start)) {
      if (minCost[end] < sum + bus.price) {
        continue;
      }

      if (bus.to == end) {
        calcTrough(bus);
        return;
      }

      if (bus.after != null) {
        findRootBus(bus.to, end, sum + bus.price);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 도시의 개수
    int m = Integer.parseInt(br.readLine()); // 버스의 개수
    buses = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      buses.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");
      int src = Integer.parseInt(input[0]);
      int dest = Integer.parseInt(input[1]);
      int price = Integer.parseInt(input[2]);
      buses.get(src).add(new Bus(dest, price));
    }

    String[] input = br.readLine().split(" ");
    int src = Integer.parseInt(input[0]);
    int dest = Integer.parseInt(input[1]);

    PriorityQueue<Bus> q = new PriorityQueue<>();
    minCost = new long[n + 1];
    Arrays.fill(minCost, Integer.MAX_VALUE);
    minCost[src] = 0;

    q.add(new Bus(src, 0));

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (!q.isEmpty()) {
      Bus bus = q.poll();
      if (bus.price > minCost[bus.to]) continue;

      for (Bus newBus : buses.get(bus.to)) {
        if (minCost[newBus.to] > minCost[bus.to] + newBus.price) {
          minCost[newBus.to] = minCost[bus.to] + newBus.price;
          bus.after = newBus;
          newBus.before = bus;
          q.add(newBus);
        }
      }
    }

    findRootBus(src, dest, 0);
    bw.write(minCost[dest] + "\n");
    bw.write(through.size() + "\n");
    for (Integer i : through) {
      bw.write(i + " ");
    }
    bw.newLine();
    bw.flush();
  }
}
