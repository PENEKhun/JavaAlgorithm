import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 3273 두 수의 합
  https://www.acmicpc.net/problem/3273
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int x = Integer.parseInt(br.readLine());

    int l = 0;
    int r = n - 1;
    int cnt = 0;
    long sum;
    Arrays.sort(arr);

    while (l < r) {
      sum = arr[l] + arr[r];

      if (sum < x) {
        l++;
      } else if (sum == x) {
        r--;
        l++;
        cnt++;
      } else {
        r--;
      }
    }

    System.out.println(cnt);
  }
}