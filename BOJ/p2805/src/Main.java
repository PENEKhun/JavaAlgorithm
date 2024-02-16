import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    BAEKJOON 2805번 나무 자르기
    https://www.acmicpc.net/problem/2805
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input1 = br.readLine().split(" ");
    int needSum = Integer.parseInt(input1[1]);
    long[] woods = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    long min = 1;
    long max = Arrays.stream(woods).max().getAsLong();
    long mid = 0;

    while(min <= max) {
      long sum = 0;
      for (long wood : woods) {
        sum += Math.max(wood - mid, 0);
      }

      if (sum < needSum) {
        max = mid - 1;
      } else if (sum > needSum) {
        min = mid + 1;
      }

      if (sum == needSum) {
        break;
      }

      mid = ((max + min) / 2);
    }

    System.out.println(mid);
  }
}
