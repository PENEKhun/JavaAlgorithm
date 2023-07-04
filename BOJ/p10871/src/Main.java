import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10871 X보다 작은 수
    url : https://www.acmicpc.net/problem/10871
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      int N = s.nextInt();
      int X = s.nextInt();
      int[] number = new int[N + 1];

      for (int i = 0; i < N; i++) {
        number[i] = s.nextInt();
      }

      for (int i = 0; i < N; i++) {
        if (number[i] < X) {
          System.out.printf(String.format("%d ", number[i]));
        }
      }
    }
}
