import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1475 방 번호
  https://www.acmicpc.net/problem/1475
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] n = br.readLine().split("");
    boolean[][] set = new boolean[1_000_001][10];
    int result = 1;
    for (int j = 0; j < n.length; j++) {
      String num = n[j];
      int number = Integer.parseInt(num);
      boolean processed = false;
      for (int i = 0; i < result; i++) {
        if (!set[i][number]) {
          set[i][number] = true;
          processed = true;
          break;
        } else if (number == 6 || number == 9) {
          if (!set[i][6]) {
            set[i][6] = true;
            processed = true;
            break;
          }

          if (!set[i][9]) {
            set[i][9] = true;
            processed = true;
            break;
          }
        }
      }
      if (!processed) {
        result++;
        j--;
      }
    }

    System.out.println(result);
  }
}