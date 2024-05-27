import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 2467 용액
  https://www.acmicpc.net/problem/2467
*/


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int size = Integer.parseInt(br.readLine());
    int[] posion = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(posion);

    long minSum = Long.MAX_VALUE;
    int[] result = new int[2];
    int l = 0;
    int r = size - 1;

    while (l < r) {
      long sum = (long) posion[l] + posion[r];

      if (Math.abs(sum) < Math.abs(minSum)) {
        minSum = sum;
        result[0] = posion[l];
        result[1] = posion[r];
      }

      if (sum == 0) {
        break;
      } else if (sum > 0) {
        r--;
      } else {
        l++;
      }
    }

    bw.write(result[0] + " " + result[1] + "\n");
    bw.flush();
  }
}