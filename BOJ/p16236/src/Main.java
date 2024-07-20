import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
  BAEKJOON 16236 아기 상어
  https://www.acmicpc.net/problem/16236
*/

public class Main {
  static int[][] map;
  static int n;
  static Map<Integer, HashSet<Position>> fish = new HashMap<>();
  static int[][] delta = new int[][] {
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  static class Position {
    public int x;
    public int y;
    public int size;
    public int temp;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Position(int x, int y, int size) {
      this.x = x;
      this.y = y;
      this.size = size;
    }

    public Position(int x, int y, int size, int temp) {
      this.x = x;
      this.y = y;
      this.size = size;
      this.temp = temp;
    }

    public int getDistance(int compareX, int compareY) {
      return Math.abs(compareX - x) + Math.abs(compareY - y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Position position = (Position) o;
      return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }

  static void bfs(int x, int y, int mySize, int times, int exp) {
    Queue<Position> q = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    q.add(new Position(x, y, mySize, 0));
    visited[y][x] = true;
    PriorityQueue<Position> fishToEat = new PriorityQueue<>((f1, f2) -> {
      if (f1.temp != f2.temp) return Integer.compare(f1.temp, f2.temp);
      if (f1.y != f2.y) return Integer.compare(f1.y, f2.y);
      return Integer.compare(f1.x, f2.x);
    });

    while (!q.isEmpty()) {
      Position current = q.poll();
      for (int[] dxy : delta) {
        int newX = dxy[0] + current.x;
        int newY = dxy[1] + current.y;
        if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newY][newX]) {
          visited[newY][newX] = true;
          if (map[newY][newX] <= mySize) {
            q.add(new Position(newX, newY, mySize, current.temp + 1));
            if (map[newY][newX] > 0 && map[newY][newX] < mySize) {
              fishToEat.add(new Position(newX, newY, map[newY][newX], current.temp + 1));
            }
          }
        }
      }
    }

    if (!fishToEat.isEmpty()) {
      Position toEat = fishToEat.poll();
      map[toEat.y][toEat.x] = 0;
      exp++;
      times += toEat.temp;
      if (exp == mySize) {
        mySize++;
        exp = 0;
      }
      bfs(toEat.x, toEat.y, mySize, times, exp);
    } else {
      System.out.println(times);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    int[] initPosition = new int[2];
    for (int i = 1; i <= 6; i++) {
      fish.put(i, new HashSet<>());
    }

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int k = 0; k < input.length; k++) {
        map[i][k] = Integer.parseInt(input[k]);
        if (map[i][k] == 9) {
          initPosition = new int[] {k, i};
          map[i][k] = 0;
        } else if (map[i][k] != 0) {
          fish.get(map[i][k]).add(new Position(k, i, map[i][k]));
        }
      }
    }


    bfs(initPosition[0], initPosition[1], 2, 0, 0);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.flush();
  }
}
