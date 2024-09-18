import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 22251 빌런 호석
  https://www.acmicpc.net/problem/22251
*/

public class Main {
  static int N, K, P, X;
  static int result = 0;
  static int[][] number = {
      {1, 1, 1, 0, 1, 1, 1}, //0
      {0, 0, 1, 0, 0, 0, 1}, //1
      {0, 1, 1, 1, 1, 1, 0}, //2
      {0, 1, 1, 1, 0, 1, 1}, //3
      {1, 0, 1, 1, 0, 0, 1}, //4
      {1, 1, 0, 1, 0, 1, 1}, //5
      {1, 1, 0, 1, 1, 1, 1}, //6
      {0, 1, 1, 0, 0, 0, 1}, //7
      {1, 1, 1, 1, 1, 1, 1}, //8
      {1, 1, 1, 1, 0, 1, 1}  //9
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    N = Integer.parseInt(inputs[0]);
    K = Integer.parseInt(inputs[1]);
    P = Integer.parseInt(inputs[2]);
    X = Integer.parseInt(inputs[3]);

    dfs(0, 0, 0);

    System.out.println(result - 1); // X 자신은 제외
  }

  static void dfs(int depth, int flips, int number) {
    if (depth == K) {
      if (flips <= P && number >= 1 && number <= N) {
        result++;
      }
      return;
    }

    for (int i = 0; i < 10; i++) {
      int newFlips = flips + countFlips(getDigit(X, K - 1 - depth), i);
      if (newFlips <= P) {
        dfs(depth + 1, newFlips, number * 10 + i);
      }
    }
  }

  static int countFlips(int from, int to) {
    int count = 0;
    for (int i = 0; i < 7; i++) {
      if (number[from][i] != number[to][i]) {
        count++;
      }
    }
    return count;
  }

  static int getDigit(int num, int pos) {
    return (num / (int)Math.pow(10, pos)) % 10;
  }
}
