import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
  BAEKJOON 1459 걷기
  https://www.acmicpc.net/problem/1459
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    BigInteger time = BigInteger.ZERO;
    int[] house = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
    int w = Integer.parseInt(input[2]); // 한 블록 시간
    int s = Integer.parseInt(input[3]); // 대각 이동 시간
    boolean sideMode = (2 * w > s);
    boolean twoMode = (2 * w > 2 * s);

    int leastSideTime = Math.min(house[0], house[1]);

    if (sideMode) {
      time = time.add(BigInteger.valueOf(leastSideTime).multiply(BigInteger.valueOf(s)));
      house[0] -= leastSideTime;
      house[1] -= leastSideTime;
    }

    if (twoMode) {
      if (house[0] >= 2) {
        BigInteger toAdd = BigInteger.valueOf(house[0] / 2).multiply(BigInteger.TWO).multiply(
            BigInteger.valueOf(s));
        time = time.add(toAdd);
        house[0] %= 2;
      }

      if (house[1] >= 2) {
        time =
            time.add(BigInteger.valueOf(house[1] / 2).multiply(BigInteger.TWO).multiply(BigInteger.valueOf(s)));
        house[1] %= 2;
      }

    }

    BigInteger toAdd = BigInteger.valueOf(house[0] + house[1]).multiply(BigInteger.valueOf(w));
    time = time.add(toAdd);
    System.out.println(time);
  }
}