import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
  BAEKJOON 11000 강의실 배정
  https://www.acmicpc.net/problem/11000
*/

public class Main {

  static class Time {
    public int start;
    public int end;

    public Time(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Time[] timeTable = new Time[n];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      timeTable[i] = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    }

    Arrays.sort(timeTable, Comparator.comparingInt(t -> t.start));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(timeTable[0].end);
    for (int i = 1; i < n; i++) {
      if (timeTable[i].start >= pq.peek()) {
        pq.poll();
      }
      pq.add(timeTable[i].end);
    }
    
    System.out.println(pq.size());
  }
}
