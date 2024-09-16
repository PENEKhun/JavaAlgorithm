import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2003 수들의 합 2
  https://www.acmicpc.net/problem/2003
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    long M = Integer.parseInt(inputs[1]);
    int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int left = 0, right = 0;

    long sum = 0;
    long result = 0;
    while (left != N) {
      sum += numbers[right];
      if (sum == M) {
        result++;
        left++;
        right = left;
        sum = 0;
      } else {
        right++;
        if (right == N) {
          left++;
          right = left;
          sum = 0;
        }
      }
    }
    System.out.println(result);
  }
}
