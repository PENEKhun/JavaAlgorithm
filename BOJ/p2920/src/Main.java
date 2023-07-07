import java.util.Arrays;
import java.util.Scanner;
/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2920 음계
    url : https://www.acmicpc.net/problem/2920
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
      int[] desc = {8, 7, 6, 5, 4, 3, 2, 1};

      int[] typed = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

      if (Arrays.equals(asc, typed)) {
        System.out.println("ascending");
      } else if (Arrays.equals(desc, typed)) {
        System.out.println("descending");
      } else {
        System.out.println("mixed");
      }
  }
}
