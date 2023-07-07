import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10250 ACM 호텔
    url : https://www.acmicpc.net/problem/10250
*/

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();

    for (int tC = 0; tC < T; tC++) {
      int maxFloor = s.nextInt();
      int maxHo = s.nextInt();
      int N = s.nextInt(); // 몇번째 손님인지...

      for (int i = 0; i < maxHo; i++) {
        for (int i1 = 0; i1 < maxFloor; i1++) {
          // 체크인 처리
          N -= 1;
          if (N == 0){
            System.out.println(String.format("%s%02d",  i1 + 1, i + 1));
          }
        }
      }
    }
  }
}
