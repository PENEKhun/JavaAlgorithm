import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
  BAEKJOON 2470 두 용액
  https://www.acmicpc.net/problem/2470
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Long> arr = Arrays.stream(br.readLine().split(" "))
        .map(Long::parseLong).sorted().collect(Collectors.toList());

    int l = 0;
    int r = n - 1;

    long min = Long.MAX_VALUE;
    int[] remember = {0, n - 1};
    while (l < r) {
      long mixed = arr.get(l) + arr.get(r);
      if (Math.abs(mixed) < Math.abs(min)) {
        min = mixed;
        remember = new int[] {l, r};
        if (mixed == 0) {
          break;
        }
      }

      if (mixed < 0) {
        l++;
      } else {
        r--;
      }
    }

    bw.write(arr.get(remember[0]) + " " + arr.get(remember[1]) + "\n");
    bw.flush();
  }
}