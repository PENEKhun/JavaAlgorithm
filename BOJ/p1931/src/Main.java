import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
/*
    BAEKJOON 1931 회의실 배정
    https://www.acmicpc.net/problem/1931
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int[][] times = new int[cases][2];
    for (int i = 0; i < cases; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      times[i] = new int[]{input[0], input[1]};
    }

    Comparator<int[]> sort = new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    }.thenComparing(
        (o1, o2) -> o1[0] - o2[0]);

    Arrays.sort(
        times,
        sort
    );

    int cnt = 1;
    int minH = times[0][0];
    int maxH = times[0][1];

    for (int i = 1; i < times.length; i++) {
      int startH = times[i][0];
      int endH = times[i][1];

      if (startH >= maxH) {
        minH = startH;
        maxH = endH;
        cnt++;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(cnt + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
