import static java.math.BigInteger.ONE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1010 다리 놓기
    url : https://www.acmicpc.net/problem/1010
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      BigInteger mFact = factorial(m);
      BigInteger nFact = factorial(n);

      // 1~m 중에 n개를 작은 숫자 순으로 뽑는 경우

      /*
      c(m,n) = 
       */

      int sub = m - n;
      BigInteger subFact = factorial(sub);

      BigInteger result = mFact.divide(nFact.multiply(subFact));
      bw.write(String.valueOf(result) + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static BigInteger factorial(int m) {
    if (m == 0) {
      return ONE;
    }

    BigInteger result = ONE;
    for (int i = 2; i <= m; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}
