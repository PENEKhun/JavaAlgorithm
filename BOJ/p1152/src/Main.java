import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1152 단어의 개수
    url : https://www.acmicpc.net/problem/1152
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String str = s.nextLine().stripLeading();
      if (str.isEmpty()) {
        System.out.println(0);
        return;
      }
      
      System.out.println(str.split(" ").length);
  }
}
