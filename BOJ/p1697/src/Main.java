import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1697 숨바꼭질
    url : https://www.acmicpc.net/problem/1697
*/

public class Main {

  static int myPosition;
  static int destination;
  static boolean[] visited = new boolean[100_001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    myPosition = Integer.parseInt(input[0]);
    destination = Integer.parseInt(input[1]);

    int value = bfs();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(value + "\n");
    bw.flush();

    bw.close();
    br.close();
  }

  private static int bfs() {
    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[]{myPosition, 0});
    visited[myPosition] = true;

    while (!queue.isEmpty()) {
      int[] row = queue.poll();
      int nowPosition = row[0];
      int nowSecond = row[1];
      int[] root = new int[]{
          nowPosition - 1,
          nowPosition + 1,
          nowPosition * 2
      };

      if (nowPosition == destination) {
        return nowSecond;
      }

      for (int i = 0; i < 3; i++) {
        int nextPosition = root[i];
        if (nextPosition < 0 || nextPosition > 100_000) {
          continue;
        }

        if (!visited[nextPosition]) {
          visited[nextPosition] = true;
          queue.offer(new int[]{nextPosition, nowSecond + 1});
        }
      }
    }

    return -1;
  }
}
