import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
      BAEKJOON 10610 30
      https://www.acmicpc.net/problem/10610
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String number = br.readLine();

    if (!number.contains("0")) {
      System.out.println(-1);
      return;
    }

    int[] arr = number.chars().map(c -> c - '0').sorted().toArray();
    StringBuilder result = new StringBuilder();

    for (int i = arr.length - 1; i >= 0; i--) {
      result.append(arr[i]);
    }

    BigInteger bigInteger = new BigInteger(result.toString());
    if (!bigInteger.mod(BigInteger.valueOf(30L)).equals(BigInteger.ZERO)) {
      System.out.println(-1);
      return;
    }

    System.out.println(result);
  }
}
