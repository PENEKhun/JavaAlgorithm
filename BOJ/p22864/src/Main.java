import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 22864 피로도
  https://www.acmicpc.net/problem/22864
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] ABCM = br.readLine().split(" ");
    int A = Integer.parseInt(ABCM[0]); // 한시간 일하면 쌓이는 피로도
    int B = Integer.parseInt(ABCM[1]); // 한시간 일하면 처리할 수 있는 양
    int C = Integer.parseInt(ABCM[2]); // 한시간 쉬면 증가하는 피로도 (피로도는 0이 최소)
    int M = Integer.parseInt(ABCM[3]); // 피로도가 M을 넘지 않게 일할거임.

    int fatigue = 0; // 현재 피로도
    int workDone = 0; // 처리한 일의 양

    for (int i = 0; i < 24; i++) {
      if (fatigue + A <= M) {
        fatigue += A;
        workDone += B;
      } else {
        fatigue = Math.max(0, fatigue - C);
      }
    }

    System.out.println(workDone);
  }
}
