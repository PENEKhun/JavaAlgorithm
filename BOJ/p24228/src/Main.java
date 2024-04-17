import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
  BAEKJOON 24228 젓가락
  https://www.acmicpc.net/problem/24228
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    BigInteger n = new BigInteger(input[0]);
    BigInteger r = new BigInteger(input[1]);

    System.out.println(n.add(
        BigInteger.TWO.multiply(
            r.subtract(BigInteger.ONE)
        ).add(BigInteger.ONE)
    ));
  }
}