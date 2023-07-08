import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2588 곱셈
    url : https://www.acmicpc.net/problem/2588
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int A = s.nextInt();
      String B = s.next();

        System.out.println(A* Character.getNumericValue(B.codePointAt(2)));
        System.out.println(A* Character.getNumericValue(B.codePointAt(1)));
        System.out.println(A* Character.getNumericValue(B.codePointAt(0)));
        System.out.println(A* Integer.valueOf(B));
  }
}
