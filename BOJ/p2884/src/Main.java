import java.time.LocalTime;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2884 알람 시계
    url : https://www.acmicpc.net/problem/2884
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      LocalTime lt = LocalTime.of(s.nextInt(), s.nextInt());
      LocalTime forYou = lt.minusMinutes(45);

      System.out.println(forYou.getHour() + " " + forYou.getMinute());
  }
}
