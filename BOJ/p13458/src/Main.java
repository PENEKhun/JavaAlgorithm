import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

/*
  BAEKJOON 13458 시험 감독
  https://www.acmicpc.net/problem/13458
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine()); // 시험장 수
    int[] peoples =
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 시험장 마다, 응사지 수
    String[] inputs = br.readLine().split(" ");
    int masterCoverable = Integer.parseInt(inputs[0]); // 총감독관 체크가능한
    int subCoverable = Integer.parseInt(inputs[1]); // 부감독관

    BigInteger result = BigInteger.ZERO;
    for (int people : peoples) {
        people -= masterCoverable;
        result = result.add(BigInteger.ONE);

      if (people > 0) {
        result = result.add(BigInteger.valueOf(people / subCoverable));
        people %= subCoverable;
        if (people % subCoverable != 0) {
          result = result.add(BigInteger.ONE);
        }
      }
    }

    bw.write(result + "\n");
    bw.flush();
  }
}