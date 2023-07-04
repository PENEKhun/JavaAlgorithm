import static java.lang.Character.isLowerCase;

import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2744 대소문자 바꾸기
    url : https://www.acmicpc.net/problem/2744
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String str = s.nextLine();

      str.chars()
          .mapToObj(Main::changeCharCase)
          .forEach(System.out::print);
    }

  private static Character changeCharCase(int c) {
    if (Character.isLowerCase(c)) {
      return Character.toUpperCase((char) c);
    } else if (Character.isUpperCase(c)) {
      return Character.toLowerCase((char) c);
    } else {
      return (char) c;
    }
  }
}
