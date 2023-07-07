import java.util.Scanner;
/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2577 숫자의 개수
    url : https://www.acmicpc.net/problem/2577
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String ABC = String.valueOf(s.nextInt() * s.nextInt() * s.nextInt());

      for (int i = 0; i < 10; i++){
        // 문자열에서 word count를 replace를 통하여 length 비교를해서 확인하는 트릭도 있음.
        System.out.println(
            ABC.length() - ABC.replaceAll(String.valueOf(i), "").length()
        );
      }
  }
}
