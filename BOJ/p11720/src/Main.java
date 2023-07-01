import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11720 숫자의 합
    url : https://www.acmicpc.net/problem/11720
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      String numbers = s.next();
      int result = 0;

      for (int i = 0; i < numbers.length(); i++) {
        String num = String.valueOf(numbers.charAt(i));
        result += Integer.valueOf(num);
      }

      System.out.println(result);
  }
}
