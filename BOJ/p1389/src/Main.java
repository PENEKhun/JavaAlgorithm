import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 1389 케빈 베이컨의 6단계 법칙
  https://www.acmicpc.net/problem/1389
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int people = Integer.parseInt(input[0]);
    int data = Integer.parseInt(input[1]);
    // init
    int[][] distance = new int[people + 1][people + 1];
    for (int i = 0; i <= people; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < data; i++) {
      int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      distance[s[0]][s[1]] = 1;
      distance[s[1]][s[0]] = 1;
    }

    for (int through = 1; through <= people; through++) {
      for (int start = 1; start <= people; start++) {
        for (int end = 1; end <= people; end++) {
          if (distance[start][through] == Integer.MAX_VALUE) {
            continue;
          }

          if (distance[through][end] == Integer.MAX_VALUE) {
            continue;
          }

          distance[start][end] =
              Math.min(distance[start][end], distance[start][through] + distance[through][end]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int minNumber = Integer.MAX_VALUE;
    for (int i = 1; i <= people; i++) {
      int distanceSum = 0;
      for (int k = 1; k <= people; k++) {
        if (i == k) {
          continue;
        }

        distanceSum += distance[i][k];
      }

      if (min > distanceSum) {
        min = distanceSum;
        minNumber = i;
      }
    }

    bw.write(minNumber + "\n");
    bw.flush();
  }
}