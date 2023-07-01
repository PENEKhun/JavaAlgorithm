/*
    BAEKJOON - 14681 번
    url : https://www.acmicpc.net/problem/14681
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      /*
        2 (-,+) | 1 (+,+)
        ------------------
        3 (-,-) | 4 (+,-)
      */
      Scanner s = new Scanner(System.in);
      int x = s.nextInt();
      int y = s.nextInt();

      if (x > 0 && y > 0){
        System.out.println(1);
      }

      if (x > 0 && y < 0){
        System.out.println(4);
      }

      if (x < 0 && y > 0){
        System.out.println(2);
      }

      if (x < 0 && y < 0){
        System.out.println(3);
      }

  }
}

