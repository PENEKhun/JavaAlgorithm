import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10809 알파벳 찾기
    url : https://www.acmicpc.net/problem/10809
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String input = s.next();

      for (int i = (int) 'a'; i <= ((int) ('z')); i++) {
        System.out.print(input.indexOf(i) + " ");
      }
  }
}
