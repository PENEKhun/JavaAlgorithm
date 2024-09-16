import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2011 암호코드
  https://www.acmicpc.net/problem/2011
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] encrypted = br.readLine().toCharArray();
    int[] num = new int[encrypted.length + 1];
    for (int i = 0; i < encrypted.length; i++) {
      try {
        num[i+1] = (encrypted[i] - '0');
      } catch (Exception e) {
        System.out.println(0);
        return;
      }
    }

    if (num[1] == 0) {
      System.out.println(0);
      return;
    }

    int[] memo = new int[num.length];
    memo[0] = 1;
    memo[1] = 1;
    for (int i = 2; i <= encrypted.length; i++) {
      if (num[i] == 0) {
        if (num[i-1] == 1 || num[i-1] == 2) {
          memo[i] = memo[i-2];
        } else {
          System.out.println(0);
          return;
        }
      } else {
        memo[i] = memo[i-1];
        if (num[i-1] == 1 || (num[i-1] == 2 && num[i] <= 6)) {
          memo[i] = (memo[i] + memo[i-2]) % 1000000;
        }
      }
    }

    System.out.println(memo[memo.length - 1]);
  }
}
