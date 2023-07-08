import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2525 오븐 시계
    url : https://www.acmicpc.net/problem/2525
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int h = s.nextInt();
      int m = s.nextInt();
      LocalTime time = LocalTime.of(h, m);
      int afterMin = s.nextInt();
      time = time.plusMinutes(afterMin);
      System.out.println(time.getHour() + " " + time.getMinute());
  }
}
