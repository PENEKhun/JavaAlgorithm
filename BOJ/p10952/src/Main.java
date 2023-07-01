import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 10952 번- A+B - 5
    url : https://www.acmicpc.net/problem/10952
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      while(true) {
        int a = s.nextInt();
        int b = s.nextInt();

        if (a == 0 && b == 0) {
          break;
        }
          System.out.println(a + b);
      }

  }
}
