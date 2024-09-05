import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 18111 마인크래프트
  https://www.acmicpc.net/problem/18111
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int y = Integer.parseInt(input[0]);
    int x = Integer.parseInt(input[1]);
    int bag = Integer.parseInt(input[2]);
    int[][] z = new int[y][x];
    int min = 256;
    int max = 0;

    for (int i = 0; i < y; i++) {
      String[] height = br.readLine().split(" ");
      for (int k = 0; k < height.length; k++) {
        int val = Integer.parseInt(height[k]);
        z[i][k] = val;
        min = Math.min(min, val);
        max = Math.max(max, val);
      }
    }

    int ansTime = Integer.MAX_VALUE;
    int ansHeight = 0;
    for (int height = min; height <= max; height++) {
      int remain = bag;
      int time = 0;

      for (int[] row : z) {
        for (int i = 0; i < x; i++) {
          int diff = Math.abs(row[i] - height);
          if (row[i] > height) {
            // 만약 더 높다면 = 빼기 2초
            time += (2 * diff);
            remain += diff;
          } else if (row[i] < height) {
            // 더 낮다면 = 쌓기
            time += diff;
            remain -= diff;
          }
        }
      }

      if (remain >= 0 && ansTime >= time) {
        ansTime = time;
        ansHeight = height;
      }
    }

    System.out.println(ansTime + " " + ansHeight);
  }
}
