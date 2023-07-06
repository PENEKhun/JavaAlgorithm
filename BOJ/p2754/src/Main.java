import java.util.HashMap;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2754 학점계산
    url : https://www.acmicpc.net/problem/2754
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      HashMap<String, Double> scoreTable = new HashMap<>();
      scoreTable.put("A+", 4.3);
      scoreTable.put("A0", 4.0);
      scoreTable.put("A-", 3.7);
      scoreTable.put("B+", 3.3);
      scoreTable.put("B0", 3.0);
      scoreTable.put("B-", 2.7);
      scoreTable.put("C+", 2.3);
      scoreTable.put("C0", 2.0);
      scoreTable.put("C-", 1.7);
      scoreTable.put("D+", 1.3);
      scoreTable.put("D0", 1.0);
      scoreTable.put("D-", 0.7);
      scoreTable.put("F", 0.0);

      System.out.println(scoreTable.get(s.next()));
  }
}
