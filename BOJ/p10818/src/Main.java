import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    sovled BAEKJOON #10818 최소, 최대
    url : https://www.acmicpc.net/problem/10818
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      List<Integer> table = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        table.add(s.nextInt());
      }

      table.sort(Integer::compareTo);

      // min
      System.out.println(table.get(0));
      // max
      System.out.println(table.get(n-1));

  }
}
