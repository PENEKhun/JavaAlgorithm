import java.util.Arrays;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1654 랜선 자르기
    url : https://www.acmicpc.net/problem/1654
*/

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int have = s.nextInt(); // 이미 가지고 있는 랜선 수
    int need = s.nextInt(); // 필요한 랜선 수 (이걸 넘겨도 됨)

    int[] length = new int[have];
    for (int i = 0; i < have; i++) {
      length[i] = s.nextInt();
    }
    
    int high = Arrays.stream(length).max().getAsInt() + 1;
    int low = 0;
    int mid;

    while (low <= high) {
      mid = ((high + low) / 2);

      long canMake = 0;
      for (int item : length) {
        canMake += item / mid;
      }

      if (canMake < need) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    System.out.println(low - 1);
  }
}
