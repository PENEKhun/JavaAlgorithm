import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON #1085 직사각형에서 탈출
    url : https://www.acmicpc.net/problem/1085
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      // 한수의 위치 좌표 (x,y)
      int x = s.nextInt(), y = s.nextInt();

      // 왼쪽아래 꼭짓점 (0,0)
      // 오른쪽위 꼿짓점 (w,h)
      int w = s.nextInt(), h = s.nextInt();

      List<Integer> result = new ArrayList<>();

      // 상단으로 접근 하는 거리
      result.add(Math.abs(y-h));

      // 하단으로 접근 하는 거리
      result.add(Math.abs(y));

      //       우측으로 접근 하는 거리
      result.add(Math.abs(x-w));

      //       좌측으로 접근 하는 거리
      result.add(Math.abs(x));

      // 최소 결과 출력
      result.sort(Integer::compareTo);

      System.out.println(result.get(0));
  }
}
