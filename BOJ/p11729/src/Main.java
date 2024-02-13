import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
      BAEKJOON 11729 하노이 탑 이동 순서
      https://www.acmicpc.net/problem/11729
*/

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    sb.append((int) (Math.pow(2, n) - 1)).append('\n');

    Hanoi(n, 1, 2, 3);
    System.out.print(sb);
  }

  public static void Hanoi(int n, int start, int mid, int to) {
    if (n == 1) {
      sb.append(start + " " + to + "\n");
      return;
    }

    Hanoi(n - 1, start, to, mid);
    sb.append(start + " " + to + "\n");
    Hanoi(n - 1, mid, start, to);
  }
}

