import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2212 센서
  https://www.acmicpc.net/problem/2212
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 센서의 갯수
    int k = Integer.parseInt(br.readLine()); // 집중국 갯수
    int[] sensor = Arrays.stream(br.readLine().split(" ")) // 센서 좌표
        .mapToInt(Integer::parseInt)
        .distinct()
        .toArray();

    Arrays.sort(sensor);
    int[] diff = new int[sensor.length - 1];
    for (int i = 0; i < diff.length; i++) {
      diff[i] = Math.abs(sensor[i] - sensor[i + 1]);
    }

    Arrays.sort(diff);
    long result = 0;
    for (int i = 0; i < diff.length - (k - 1); i++) {
      result += diff[i];
    }

    System.out.println(result);
  }
}
