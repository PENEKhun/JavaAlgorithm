import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 12851 숨바꼭질 2
  https://www.acmicpc.net/problem/12851
*/

public class Main {
  static class Subin {
    int position;
    int seconds = 0;

    public Subin(int position) {
      this.position = position;
    }

    public Subin(int position, int seconds) {
      this.position = position;
      this.seconds = seconds;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int src = Integer.parseInt(input[0]);
    int dest = Integer.parseInt(input[1]);

    Queue<Subin> q = new LinkedList<>();
    q.add(new Subin(src));

    int MAX_ARR = 150_002;
    int minSec = Integer.MAX_VALUE;
    int[] costMany = new int[MAX_ARR];
    int[] costVisited = new int[MAX_ARR];
    Arrays.fill(costVisited, MAX_ARR);

    while (!q.isEmpty()) {
      Subin subin = q.poll();

      if (subin.seconds > minSec) {
        continue;
      }

      if (subin.position == dest) {
        minSec = subin.seconds;
        costMany[minSec]++;
        continue;
      }

      int[] nextOffset = new int[] {1, -1, subin.position};
      for (int i = 0; i < 3; i++) {
        int next = subin.position + nextOffset[i];
        if (next < 0 || next >= MAX_ARR) {
          continue;
        }

        if (costVisited[next] >= subin.seconds + 1) {
          costVisited[next] = subin.seconds + 1;
          q.add(new Subin(next, subin.seconds + 1));
        }
      }
    }

    StringBuilder sb = new StringBuilder().append(minSec).append("\n").append(costMany[minSec]).append("\n");
    System.out.print(sb);
  }
}
