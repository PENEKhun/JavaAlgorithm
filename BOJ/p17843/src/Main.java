import java.io.*;
import java.util.Arrays;

/*
    BAEKJOON 17843 시계
    https://www.acmicpc.net/problem/17843

*/

public class Main {

  public static double calc(double a, double b) {
    double diff = Math.abs(a - b);
    return Math.min(diff, 360.0 - diff);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      double h = Double.parseDouble(input[0]);
      double m = Double.parseDouble(input[1]);
      double s = Double.parseDouble(input[2]);

      double sAngle = s * 6.0; // 초각
      double mAngle = (m * 6.0) + (s / 60.0 * 6.0); // 분각
      double hAngle = (h * 30.0) + (m / 60.0 * 30.0) + (s / 3600.0 * 30.0); // 시각

      double[] angles = new double[]{hAngle, mAngle, sAngle};

      double[] diffs = new double[3];
      diffs[0] = calc(angles[0], angles[1]);
      diffs[1] = calc(angles[0], angles[2]);
      diffs[2] = calc(angles[1], angles[2]);

      bw.write(String.format("%.6f", Arrays.stream(diffs).min().getAsDouble()) + "\n");
    }
    bw.flush();
    bw.close();
  }
}
