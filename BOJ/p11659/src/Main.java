import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    BAEKJOON 11659 구간 합 구하기 4
    https://www.acmicpc.net/problem/11659
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int m = Integer.parseInt(input[1]); // 합을 구해야 하는 횟수 M
    int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N개의 수
    int[][] sumArrange = new int[m][2]; // 합을 구해야하는 범위들
    for (int i = 0; i < m; i++) {
      sumArrange[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long[] sums = new long[nums.length];
    sums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sums[i] = sums[i-1] + nums[i];
    }

    for (int[] arrange : sumArrange) {
      int to = arrange[0] - 1;
      int from = arrange[1] - 1;

      long sum = sums[from] - ((to == 0) ? 0 : sums[to-1]);
      bw.write(sum + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
