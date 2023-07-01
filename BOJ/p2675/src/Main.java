import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2675 문자열 반복
    url : https://www.acmicpc.net/problem/2675
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      for (int i = 0; i < n; i++) {
        int r = s.nextInt(); // 반복 횟수
        String str = s.nextLine().replace(" ", ""); // 문자

        int q = 0;
        for (int k = 1; k < str.length() * r + 1; k++) {
          System.out.print(str.charAt(q));
          if (k % r == 0)
            q++;
        }
        System.out.println();
      }
  }
}
