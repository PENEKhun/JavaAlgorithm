import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #27866 문자와 문자열
    url : https://www.acmicpc.net/problem/27866
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String str = s.nextLine();
      int index = s.nextInt();

      System.out.println(str.charAt(index-1));
  }
}
