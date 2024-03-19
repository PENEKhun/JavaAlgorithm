import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 14916 거스름돈
  https://www.acmicpc.net/problem/14916
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int num = n;
    int two = 0;
    int five = 0;
    while (true) {
      if (n % 5 == 0) {
        five = n / 5;
        break;
      }
      two++;
      n -= 2;
      
      if (n < 0) {
        break;
      }
    }

    if (two * 2 + five * 5 != num) {
      System.out.println("-1");
    } else {
      System.out.println(two + five);
    }
  }
}