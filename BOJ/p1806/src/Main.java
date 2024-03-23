import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 1806 부분합
  https://www.acmicpc.net/problem/1806
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int s = Integer.parseInt(input[1]);
    int[] arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int sum = arr[0];
    int ret = Integer.MAX_VALUE;

    int l = 0;
    int r = 0;
    while (l <= r) {
      if (sum >= s) {
        sum -= arr[l];
        ret = Math.min(ret, r - l + 1);
        l++;
      } else {
        r++;
        if (r == n) {
          break;
        }

        sum += arr[r];
      }
    }

    if (ret == Integer.MAX_VALUE) {
      bw.write("0\n");
    } else {
      bw.write(ret + "\n");
    }

    bw.flush();
  }
}