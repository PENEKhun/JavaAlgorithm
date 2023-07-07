import java.util.Arrays;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #3052 나머지
    url : https://www.acmicpc.net/problem/3052
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      int[] number = new int[10];
      for (int i = 0; i < number.length; i++) {
        number[i] = s.nextInt() % 42;
      }

      System.out.println(Arrays.stream(number).distinct().count());
  }
}
