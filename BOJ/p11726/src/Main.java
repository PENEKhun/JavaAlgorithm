import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11726 2×n 타일링
    url : https://www.acmicpc.net/problem/11726
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    BigInteger[] memo = new BigInteger[n + 5];
    memo[1] = BigInteger.ONE;
    memo[2] = BigInteger.TWO;

    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i - 2].add(memo[i - 1]);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write((memo[n].divideAndRemainder(BigInteger.valueOf(10_007)))[1] + "\n");
    bw.flush();

    bw.close();
    br.close();
  }
}
