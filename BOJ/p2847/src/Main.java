import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 2847 게임을 만든 동준이
  https://www.acmicpc.net/problem/2847
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] levelScore = new int[n];
    for (int i = 0; i < n; i++) {
      levelScore[i] = Integer.parseInt(br.readLine());
    }

    int result = 0;
    for (int i = n - 1; i >= 1; i--) {
      if (levelScore[i - 1] >= levelScore[i]) {
        int diff = levelScore[i - 1] - levelScore[i] + 1;
        result += diff;
        levelScore[i - 1] -= diff;
      }
    }
    System.out.println(result);
  }
}