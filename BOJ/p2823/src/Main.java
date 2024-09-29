import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 2823 유턴 싫어
  https://www.acmicpc.net/problem/2823
*/

public class Main {
  static int[][] dxy = new int[][] {
      // 상 하 좌 우
      {0, -1}, {0, 1}, {-1, 0}, {1, 0}
  };

  public enum Mark {
    BUILDING('X'),
    ROAD('.'),
    ;

    char val;

    Mark(char val) {
      this.val = val;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] RC = br.readLine().split(" ");
    int height = Integer.parseInt(RC[0]);
    int width = Integer.parseInt(RC[1]);

    Mark[][] map = new Mark[height][width];
    for (int i = 0; i < height; i++) {
      char[] arr = br.readLine().toCharArray();
      for (int k = 0; k < arr.length; k++) {
        if (arr[k] == Mark.BUILDING.val) {
          map[i][k] = Mark.BUILDING;
        } else {
          map[i][k] = Mark.ROAD;
        }
      }
    }

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (map[y][x] == Mark.ROAD) {
          int roadCount = 0;
          for (int[] xy : dxy) {
            int newX = x + xy[0];
            int newY = y + xy[1];
            if (newX >= 0 && newX < width && newY >= 0 && newY < height && map[newY][newX] == Mark.ROAD) {
              roadCount++;
            }
          }
          if (roadCount <= 1) {
            System.out.println("1");
            return;
          }
        }
      }
    }

    System.out.println("0");
  }
}
