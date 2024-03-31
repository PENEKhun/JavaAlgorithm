import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 16953 A → B
  https://www.acmicpc.net/problem/16953
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);

    int cnt = 0;
    while (a < b) {
      if (b % 10 == 1) {
        b /= 10;
        cnt++;
      } else if (b % 2 == 0) {
        b /= 2;
        cnt++;
      } else {
        cnt = -1;
        break;
      }
    }

    if (cnt == -1 || a != b) {
      System.out.println(-1);
    } else {
      System.out.println(cnt + 1);
    }

  }
}