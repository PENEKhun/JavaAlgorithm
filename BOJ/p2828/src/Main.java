import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 2828 사과 담기 게임
  https://www.acmicpc.net/problem/2828
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);
    int J = Integer.parseInt(br.readLine());

    int[] drop = new int[J]; // 사과 떨어짐
    for (int i = 0; i < J; i++) {
      drop[i] = Integer.parseInt(br.readLine());
    }

    int result = 0;
    int bagStart = 1;
    int bagEnd = M;
    int appleIdx = 0;
    while (appleIdx != J) {
      int applePos = drop[appleIdx];
      if (bagStart <= applePos && bagEnd >= applePos) {
        appleIdx++;
        continue;
      }

      int diff = 0;
      if (bagStart > applePos) {
        // 왼쪽으로 움직여야 함.
        diff = bagStart - applePos;
      } else {
        // 오른쪽으로 움직여야 함.
        diff = bagEnd - applePos;
      }

      bagStart -= diff;
      bagEnd -= diff;
      result += Math.abs(diff);
      appleIdx++;
    }

    System.out.println(result);
  }
}
