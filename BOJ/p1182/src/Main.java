import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 1182 부분수열의 합
  https://www.acmicpc.net/problem/1182
*/

public class Main {

  static int n, s;
  static int[] numbers;
  static int result = 0;

  static void find(int idx, int sum) {
    if (idx == n - 1 && sum != s) {
      return;
    } else if (sum == s) {
      result += 1;
    }

    for (int i = idx + 1; i < n; i++) {
      find(i, sum + numbers[i]);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    s = Integer.parseInt(input[1]);

    numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i = n - 1; i >= 0; i--) {
      find(i, numbers[i]);
    }

    System.out.println(result);
  }
}