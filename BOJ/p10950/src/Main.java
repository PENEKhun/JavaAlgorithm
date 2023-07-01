import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 10950 번- A+B - 3
    url : https://www.acmicpc.net/problem/10950
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      /*
        0 < A
        B < 10
      */

      int caseCnt = s.nextInt();
      while(caseCnt > 0){
        System.out.println(s.nextInt() + s.nextInt());
        caseCnt--;
      }
  }
}
