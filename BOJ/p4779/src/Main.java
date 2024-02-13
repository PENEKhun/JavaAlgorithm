import java.util.Scanner;

/*
      BAEKJOON 4779 칸토어 집합
      https://www.acmicpc.net/problem/4779
*/

public class Main {

  // n = 1, ---, - -, 2번
  // n = 2, ---------, ---   ---, - -   - - 3번
  // n = 3, 4번
  static void recur(int n, String str) {
    // 탈출 조건
    if (n == 2) {
      System.out.print(" ".repeat(str.length()));
      return;
    }

    if (str.length() == 3) {
      System.out.print("- -");
      return;
    }

    // 중간을 동강!!
    int midStart = str.length() / 3 + 1;
    int midEnd = midStart * 2 - 2;
    recur(1, str.substring(0, midStart - 1));
    recur(2, str.substring(midStart - 1, midEnd));
    recur(3, str.substring(midEnd));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      if (n == 0) {
        System.out.println("-");
        continue;
      }
      if (n == 1) {
        System.out.println("- -");
        continue;
      }
      recur(n + 1, "-".repeat((int) Math.pow(3, n)));
      System.out.println();
    }
  }
}
