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
    int n = Integer.parseInt(NM[0]); // 과목수
    int m = Integer.parseInt(NM[1]); // 성준이의 마일리지
    int[][] score = new int[n][]; // 과목별 마일리지 얼마나

    // 사용해야하는 최소 마일리지
    int[] resultTable = new int[n];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");

      int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
          .sorted()
          .toArray();
      Arrays.sort(temp);
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
