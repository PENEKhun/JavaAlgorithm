import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #8958 OX퀴즈
    url : https://www.acmicpc.net/problem/8958
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      for (int i = 0; i < n; i++) {
        String omr = s.next();
        int totalScore = 0;
        int againScore = 0;
        for (int i1 = 0; i1 < omr.length(); i1++) {
          if (omr.charAt(i1) == 'O'){
            againScore += 1;
            totalScore += againScore;
          } else {
            againScore = 0;
          }
        }
        System.out.println(totalScore);
      }
  }
}
