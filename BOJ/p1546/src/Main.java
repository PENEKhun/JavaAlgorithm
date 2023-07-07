import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1546 평균
    url : https://www.acmicpc.net/problem/1546
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int[] originalScore = new int[n];
      for (int i = 0; i < n; i++) {
        originalScore[i] = s.nextInt();
      }

      int max = Arrays.stream(originalScore).max().getAsInt();
      BigDecimal sum = BigDecimal.valueOf(0.0);

      for (int i = 0; i < originalScore.length; i++) {
        // calc
        sum = sum.add(
            BigDecimal.valueOf(originalScore[i])
                .divide(BigDecimal.valueOf(max), 12, RoundingMode.CEILING)
                .multiply(BigDecimal.valueOf(100))
        );
      }

      System.out.println(sum.divide(BigDecimal.valueOf(originalScore.length), 12, RoundingMode.CEILING));
  }
}
