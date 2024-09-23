import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 14442 벽 부수고 이동하기 2
  https://www.acmicpc.net/problem/14442
*/

public class Main {
  static int[][] deltaXY = new int[][] {
      // 상, 하, 좌, 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public static class Move {
    int x;
    int y;
    int remainBreak;
    int distance;

    public Move(int remainBreak, int distance) {
      this.remainBreak = remainBreak;
      this.distance = distance;
    }

    public Move(int x, int y, int remainBreak, int distance) {
      this.x = x;
      this.y = y;
      this.remainBreak = remainBreak;
      this.distance = distance;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NMK = br.readLine().split(" ");
    int N = Integer.parseInt(NMK[0]); // height
    int M = Integer.parseInt(NMK[1]); // width
    int K = Integer.parseInt(NMK[2]); // 최대 벽부수기 수
    char[][] map = new char[N][];
    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    boolean[][][] visited = new boolean[K + 1][N][M];
    // 0, 0 -> n-1 m-1
    Queue<Move> q = new LinkedList<>();
    visited[K][0][0] = true;

    q.add(new Move(K, 1));
    while (!q.isEmpty()) {
      Move poll = q.poll();
      int x = poll.x;
      int y = poll.y;
      int distance = poll.distance;
      int remainBreak = poll.remainBreak;

      if (x == M - 1 && y == N - 1) {
        System.out.println(distance);
        return;
      }

      for (int[] dxy : deltaXY) {
        int newX = x + dxy[0];
        int newY = y + dxy[1];

        if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
          continue;
        }

        if (map[newY][newX] == '1' && remainBreak > 0 && !visited[remainBreak - 1][newY][newX]) {
          q.add(new Move(newX, newY, remainBreak - 1, distance + 1));
          visited[remainBreak - 1][newY][newX] = true;
        } else if (map[newY][newX] == '0' && !visited[remainBreak][newY][newX]) {
          q.add(new Move(newX, newY, remainBreak, distance + 1));
          visited[remainBreak][newY][newX] = true;
        }
      }
    }

    System.out.println(-1);
  }
}
