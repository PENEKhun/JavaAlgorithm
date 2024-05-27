import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 2473 세 용액
  https://www.acmicpc.net/problem/2473
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int size = Integer.parseInt(br.readLine());
    long[] posion = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    Arrays.sort(posion);

    long minSum = Long.MAX_VALUE;
    long[] result = new long[3];

    loop:
    for (int i = 0; i < size - 2; i++) {
      int l = i + 1;
      int r = size - 1;
      while (l < r) {
        long sum = posion[i] + posion[l] + posion[r];

        if (Math.abs(sum) < Math.abs(minSum)) {
          minSum = sum;
          result[0] = posion[i];
          result[1] = posion[l];
          result[2] = posion[r];
        }

        if (sum == 0) {
          break loop;
        } else if (sum < 0) {
          l++;
        } else {
          r--;
        }
      }
    }

    bw.write(result[0] + " " + result[1] + " " + result[2] + "\n");
    bw.flush();
  }
}

