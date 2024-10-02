import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
  BAEKJOON 17836 공주님을 구해라!
  https://www.acmicpc.net/problem/17836
*/

public class Main {
  static int height, width;
  static int deadline;
  static int[][] dxy = new int[][] {
      // 상 하 좌 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };
  static int[][][] visited;
  static int[][] map = new int[height][];

  public static class Status {
    int x;
    int y;
    boolean hasSword;
    int duration;

    public Status(int x, int y, boolean hasSword, int duration) {
      this.x = x;
      this.y = y;
      this.duration = duration;
      this.hasSword = hasSword;
    }
  }

  public static int bfs(int startX, int startY, int destX, int destY) {

    Queue<Status> q = new ArrayDeque<>();
    q.add(new Status(startX, startY, false, 0));

    int result = Integer.MAX_VALUE;
    visited[0][startY][startX] = 0;
    while (!q.isEmpty()) {
      Status poll = q.poll();
      int x = poll.x;
      int y = poll.y;
      int hasSword = poll.hasSword ? 1 : 0;
      int duration = poll.duration;

      if (x == destX && y == destY) {
        result = Math.min(result, duration);
        continue;
      }

      if (duration + 1 >= result) {
        continue;
      }

      if (map[y][x] == 2) {
        hasSword = 1;
      }

      for (int[] xy : dxy) {
        int newX = x + xy[0];
        int newY = y + xy[1];
        if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
          continue;
        }

        if (map[newY][newX] == 1 && hasSword != 1) {
          continue;
        }

        int newDuration = duration + 1;
        if (visited[hasSword][newY][newX] != 0 && visited[hasSword][newY][newX] <= newDuration) {
          continue;
        }
        if (newDuration > deadline) {
          continue;
        }

        visited[hasSword][newY][newX] = newDuration;
        q.add(new Status(newX, newY, hasSword == 1, newDuration));
      }
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NMT = br.readLine().split(" ");
    height = Integer.parseInt(NMT[0]);
    width = Integer.parseInt(NMT[1]);
    deadline = Integer.parseInt(NMT[2]);
    map = new int[height][width];
    for (int i = 0; i < height; i++) {
      String[] input = br.readLine().split(" ");
      for (int k = 0; k < input.length; k++) {
        map[i][k] = Integer.parseInt(input[k]);
      }
    }

    visited = new int[2][height][width];
    int result = bfs(0, 0, width - 1, height - 1);
    if (result == Integer.MAX_VALUE) {
      System.out.println("Fail");
    } else {
      System.out.println(result);
    }
  }
}
