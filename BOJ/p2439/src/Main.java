import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2439 별 찍기 - 2
    url : https://www.acmicpc.net/problem/2439
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      for (int i = 1; i < n+1; i++) {
        System.out.println(" ".repeat(n-i) + "*".repeat(i));
      }

  }
}
