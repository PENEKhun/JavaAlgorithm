import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 12018 Yonsei TOTO
  https://www.acmicpc.net/problem/12018
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int n = Integer.parseInt(NM[0]);
    int m = Integer.parseInt(NM[1]);

    int[] resultTable = new int[n];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");

      int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
          .sorted()
          .toArray();
      int submitted = Integer.parseInt(input[0]);
      int maxMember = Integer.parseInt(input[1]);
      if (maxMember > submitted) {
        resultTable[i] = 1;
      } else {
        resultTable[i] = temp[submitted - maxMember];
      }
    }

    Arrays.sort(resultTable);
    int result = 0;
    for (int i : resultTable) {
      if (i <= m) {
        m -= i;
        result++;
      } else {
        break;
      }
    }

    System.out.println(result);
  }
}
