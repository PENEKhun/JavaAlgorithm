import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 19939 박 터뜨리기
  https://www.acmicpc.net/problem/19939
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NK = br.readLine().split(" ");
    int N = Integer.parseInt(NK[0]); // 공의 개수
    int K = Integer.parseInt(NK[1]); // 팀의 수

    int minBall = (K * (K+1)) / 2;
    if (N < minBall) {
      System.out.println(-1);
    } else if (minBall == N) {
      System.out.println(K - 1);
    } else {
      int remainBall = N - minBall;
      if (remainBall % K == 0) {
        System.out.println(K - 1);
      } else {
        System.out.println(K);
      }
    }
  }
}
