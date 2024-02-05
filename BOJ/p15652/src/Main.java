import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
      BAEKJOON 15652 N과 M (4)
      https://www.acmicpc.net/problem/15652
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int max = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    int[] arr = new int[m];
    // init
    Arrays.fill(arr, 1);
    arr[m - 1] = 0;

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true) {
      arr[m - 1]++;
      bw.write(Arrays.stream(arr).mapToObj(Integer::toString).reduce((a, b) -> a + " " + b).get());
      bw.newLine();

      if (arr[0] == max) {
        break;
      }

      if (arr[m - 1] >= max) {
        for (int i = m - 2; i >= 0; i--) {
          if (arr[i] < arr[m - 1]) {
            arr[i]++;
            for (int j = i + 1; j < m; j++) {
              arr[j] = arr[i];
            }
            arr[m - 1]--;
            break;
          }
        }
      }
    }
    bw.flush();
  }
}
