import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2475 검증수
    url : https://www.acmicpc.net/problem/2475
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println(
          (int) (
              Math.pow(s.nextInt(), 2) +
              Math.pow(s.nextInt(), 2) +
              Math.pow(s.nextInt(), 2) +
              Math.pow(s.nextInt(), 2) +
              Math.pow(s.nextInt(), 2)
          ) % 10
      );
  }
}
