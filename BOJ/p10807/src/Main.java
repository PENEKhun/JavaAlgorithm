import java.util.HashMap;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 10807 번- 개수 세기
    url : https://www.acmicpc.net/problem/10807
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      HashMap<Integer, Integer> result = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int input = s.nextInt();
        int after = result.getOrDefault(input, 0);
        result.put(input, after+1);
      }

      // 갯수 찾기
      System.out.println(result.getOrDefault(s.nextInt(), 0));
  }
}
