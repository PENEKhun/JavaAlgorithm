import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2562 최댓값
    url : https://www.acmicpc.net/problem/2562
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int[] arr = new int[10];
      for (int i = 0; i < 9; i++) {
        arr[i] = s.nextInt();
      }

      int max = Arrays.stream(arr).max().getAsInt();
      int index = -1;
      for (int i = 0; i < 9; i++) {
        if (arr[i] == max) {
          index = i+1;
          break;
        }
      }
      System.out.println(max);
      System.out.println(index);
  }
}
