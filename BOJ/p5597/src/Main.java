import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 5597 번- 과제 안 내신 분..?
    url : https://www.acmicpc.net/problem/5597
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      boolean[] attempt = new boolean[30+1];

      // 출결 기록
      for (int i = 0; i < 28; i++) {
        int attemptedNumber = s.nextShort();
        attempt[attemptedNumber] = true;
      }

      // 출결 확인
      for (int i = 1; i <= 30; i++){
        if (!attempt[i]) {
          System.out.println(i);
        }
      }
  }
}
