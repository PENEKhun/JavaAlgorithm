import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 2438 번- 별 찍기 - 1
    url : https://www.acmicpc.net/problem/2438
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      for(int i = 0; i <= n; i++){
        for(int k = 0; k < i; k++){
          System.out.printf("*");
        }

        if (i != 0)
          System.out.printf("\n");
      }
  }
}
