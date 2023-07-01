import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 2739 번- 구구단
    url : https://www.acmicpc.net/problem/2739
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int a = s.nextInt();

      for(int i = 1; i <= 9; i++){
        System.out.println(String.format("%d * %d = %d", a, i, a*i));
      }
  }
}
