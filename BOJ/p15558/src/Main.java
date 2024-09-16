import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 15558 점프 게임
  https://www.acmicpc.net/problem/15558
*/

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]); // 길이
    int K = Integer.parseInt(inputs[1]); // 건너 뛸수 있음

    Boolean[][] map = new Boolean[2][N + K + 1];
    boolean[][] visited = new boolean[2][N + K + 1];

    for (int i = 0; i < 2; i++) {
      char[] input = br.readLine().toCharArray();
      for (int k = 0; k < input.length; k++) {
        map[i][k] = input[k] == '1';
      }

      for (int q = N; q <= N + K; q++) {
        map[i][q] = true;
      }
    }
    // true = 안전함, false = 못감
    Queue<int[]> q = new LinkedList<>();
    // map, position, seconds
    q.add(new int[] {0, 0, 0});
    boolean result = false;
    while (!q.isEmpty()) {
      int[] status = q.poll();
      int nowMap = status[0];
      int position = status[1];
      int seconds = status[2];

      if (position < 0) {
        continue;
      }

      // 도착 체크
      if (position >= N + 1 - K) {
        result = true;
        break;
      }

      if (!map[nowMap][position]) {
        continue;
      }

      if (visited[nowMap][position]) {
        continue;
      }

      visited[nowMap][position] = true;

      // 한칸 앞
      if (map[nowMap][position + 1]) {
        q.add(new int[] {nowMap, position + 1, seconds + 1});
      }

      // 한칸 뒤
      if (position - 1 >= 0 && map[nowMap][position - 1]) {
        if (seconds < position - 1) {
          q.add(new int[] {nowMap, position - 1, seconds + 1});
        }
      }

      if (nowMap == 0 && map[1][position + K]) {
        q.add(new int[] {1, position + K, seconds + 1});
      } else if (nowMap == 1 && map[0][position + K]) {
        q.add(new int[] {0, position + K, seconds + 1});
      }
    }

    if (result) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
