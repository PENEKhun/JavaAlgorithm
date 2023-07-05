import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11718 그대로 출력하기
    url : https://www.acmicpc.net/problem/11718
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      while(s.hasNextLine()){
        String str = s.nextLine();
        if (str == null || str.length() < 1)
          break;

        System.out.println(str);
      }
  }
}
