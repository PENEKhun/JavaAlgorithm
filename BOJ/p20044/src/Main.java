import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 20044 Project Teams
  https://www.acmicpc.net/problem/20044
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 팀 수
    int[] skill = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(skill);

    int start = 0;
    int end = 2 * n - 1;
    int min = Integer.MAX_VALUE;

    while (start <= end) {
      min = Math.min(min, skill[start] + skill[end]);
      end--;
      start++;
    }

    System.out.println(min);
  }
}
