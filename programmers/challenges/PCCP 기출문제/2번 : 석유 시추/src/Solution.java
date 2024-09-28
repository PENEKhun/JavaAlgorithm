import java.util.*;

public class Solution {
  public int[][] dxy = new int[][] {
      // 상, 하, 좌, 우
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public int solution(int[][] land) {
    int answer = 0;
    int height = land.length;
    int width = land[0].length;

    int[] result = new int[width];
    boolean[][] visited = new boolean[height][width];
    for (int x = 0; x < width; x++) {
      // System.out.println("x is " + x);
      for (int y = 0; y < height; y++) {
        // System.out.println("y is " + y);
        if (land[y][x] == 1 && !visited[y][x]) {
          int count = 1;
          Queue<int[]> q = new LinkedList<>();
          q.add(new int[] {x, y});
          visited[y][x] = true;
          int minX = x;
          int maxX = x;

          while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int[] xy : dxy) {
              int newX = poll[0] + xy[0];
              int newY = poll[1] + xy[1];

              if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
                continue;
              }

              if (visited[newY][newX]) {
                continue;
              }

              if (land[newY][newX] == 1) {
                // System.out.println("spread " + (newX + 1) + ", " + (newY + 1));
                minX = Math.min(newX, minX);
                maxX = Math.max(newX, maxX);
                count++;
                q.add(new int[] {newX, newY});
                visited[newY][newX] = true;
              }
            }
          }

          // System.out.println("done min max is " + minX + ", " + maxX);
          for (int i = minX; i <= maxX; i++) {
            result[i] += count;
            answer = Math.max(answer, result[i]);
          }
        }
      }
    }

    return answer;
  }
}
