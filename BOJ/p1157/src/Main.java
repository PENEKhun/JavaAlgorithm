import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1157 단어 공부
    url : https://www.acmicpc.net/problem/1157
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String str = s.next().toUpperCase();
      HashMap<String, Integer> countTable = new HashMap<>();

      for (int i = 0; i < str.length(); i++) {
        String now = String.valueOf(str.charAt(i));
        countTable.put(now, countTable.getOrDefault(now, 0) + 1);
      }

      int max = countTable.values().stream().max(Integer::compareTo).get();
      if (countTable.values().stream().filter(Predicate.isEqual(max)).count() > 1){
        System.out.println("?");
      } else {
        countTable.forEach((alpabet, count) -> {
          if (count == max) {
            System.out.println(alpabet);
          }
        });
      }

      // 스트림혼종... 그냥 For문을 쓸걸 ㅋㅋ..
  }
}
