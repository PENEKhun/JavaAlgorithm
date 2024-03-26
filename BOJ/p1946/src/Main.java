import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
  BAEKJOON 1946 신입 사원
  https://www.acmicpc.net/problem/1946
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCases; i++) {
      int n = Integer.parseInt(br.readLine());
      // [] = {서류 순위, 면접 성적 순위}
      int[][] people = new int[n][2];
      for (int k = 0; k < n; k++) {
        people[k] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      Arrays.sort(people, 0, n, (o1, o2) -> {
        return o1[0] - o2[0];
      });

      ArrayList<int[]> recruit = new ArrayList<>();

      for (int[] person : people) {
        if (recruit.isEmpty()) {
          recruit.add(person);
        } else {
          int[] target = recruit.get(recruit.size() - 1);
          if (target[1] > person[1]) {
            recruit.add(person);
          }
        }
      }

      System.out.println(recruit.size());
    }
  }
}