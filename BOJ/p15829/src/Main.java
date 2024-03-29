import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
  BAEKJOON 15829 Hashing
  https://www.acmicpc.net/problem/15829
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int l = Integer.parseInt(br.readLine());
    BigInteger[] table = new BigInteger[51];
    table[0] = BigInteger.ONE;
    for (int i = 1; i <= l; i++) {
      table[i] = table[i - 1].multiply(BigInteger.valueOf(31L));
    }

    char[] strs = br.readLine().toCharArray();
    BigInteger result = BigInteger.ZERO;
    for (int i = 0; i < strs.length; i++) {
      result = result.add(
          table[i].multiply(BigInteger.valueOf(strs[i] - 96))
      );
    }

    System.out.println(result);
  }
}