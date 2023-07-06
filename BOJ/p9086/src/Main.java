import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #9086 문자열
    url : https://www.acmicpc.net/problem/9086
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();

      for (int i = 0; i < t; i++) {
        String str = s.next();
        if (str.length() == 1){
          System.out.println(String.format("%s%s", str, str));
          continue;
        }
        System.out.println(String.format("%s%s", str.charAt(0), str.charAt(str.length()-1)));
      }
  }
}
