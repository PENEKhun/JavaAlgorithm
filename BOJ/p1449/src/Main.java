import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 1449 수리공 항승
  https://www.acmicpc.net/problem/1449
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] inputs = br.readLine().split(" ");
    int brokenSpotCount = Integer.parseInt(inputs[0]);
    int tapeLength = Integer.parseInt(inputs[1]);

    int[] brokenSpots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    double beforeTapeLastPosition = -1;
    Arrays.sort(brokenSpots);
    int result = 0;
    for (int spot : brokenSpots) {
      if (beforeTapeLastPosition <= spot + 0.5) {
        beforeTapeLastPosition = spot + tapeLength + 0.5;
        result++;
      }
    }

    bw.write(result + "\n");
    bw.flush();
  }
}