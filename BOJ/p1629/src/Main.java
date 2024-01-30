import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/*
      BAEKJOON 1629 곱셈
      https://www.acmicpc.net/problem/1629
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputs[] = br.readLine().split(" ");
    int a = Integer.parseInt(inputs[0]);
    int b = Integer.parseInt(inputs[1]);
    int c = Integer.parseInt(inputs[2]);

    /*
    A를 B번 곱한 수를 C로 나눈 나머지를 출력한다. (A, B, C는 모두 2,147,483,647 이하의 자연수)
    a^b % c
    */

    // a^(exp) mod c 까지만 구하면 됨.
    BigInteger result = powMod(a, b, c);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(result.mod(BigInteger.valueOf(c)) + "\n");
    bw.flush();
    bw.close();
  }

  static BigInteger powMod(int base, int exponent, int mod) {
    BigInteger result = BigInteger.ONE;
    BigInteger baseValue = BigInteger.valueOf(base);
    while (exponent > 0) {
      if (exponent % 2 == 1) {
        result = (result.multiply(baseValue)).mod(BigInteger.valueOf(mod));
      }
      baseValue = (baseValue.multiply(baseValue)).mod(BigInteger.valueOf(mod));
      exponent /= 2;
    }
    return result;
  }
}
