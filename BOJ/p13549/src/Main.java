import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 13549 숨바꼭질 3
  https://www.acmicpc.net/problem/13549
*/

public class Main {

  static int[] memo = new int[100_001 * 3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] input = br.readLine().split(" ");
    int now = Integer.parseInt(input[0]);
    int dest = Integer.parseInt(input[1]);
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[now] = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(now);

    while (!q.isEmpty()) {
      int visit = q.poll();

      if (visit >= 1) {
        if (memo[visit - 1] > memo[visit] + 1) {
          memo[visit - 1] = memo[visit] + 1;
          q.add(visit - 1);
        }
      }

      if (visit <= 100_001) {
        if (memo[visit + 1] > memo[visit] + 1) {
          memo[visit + 1] = memo[visit] + 1;
          q.add(visit + 1);
        }

        if (memo[visit * 2] > memo[visit]) {
          memo[visit * 2] = memo[visit];
          q.add(visit * 2);
        }
      }
    }

    bw.write(memo[dest] + "\n");
    bw.flush();
  }
}