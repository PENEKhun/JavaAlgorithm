import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 1992 쿼드트리
  https://www.acmicpc.net/problem/1992
*/

public class Main {
  static int n;
  static char[][] movie;
  static StringBuilder result = new StringBuilder();

  static void solution(int startX, int startY, int length) {
    char target = movie[startY][startX];
    if (length == 1) {
      result.append(target);
      return;
    }

    boolean allSame = true;
    for (int i = startX; i < startX + length; i++) {
      for (int k = startY; k < startY + length; k++) {
        if (movie[k][i] != target) {
          allSame = false;
          break;
        }
      }
      if (!allSame) {
        break;
      }
    }

    if (allSame) {
      result.append(target);
      return;
    }

    length /= 2;
    result.append("(");
    // 1사
    solution(startX, startY, length);
    // 2사
    solution(startX + length, startY, length);
    // 3사
    solution(startX, startY + length, length);
    // 4사
    solution(startX + length, startY + length, length);
    result.append(")");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    movie = new char[n][n];
    for (int i = 0; i < n; i++) {
      movie[i] = br.readLine().toCharArray();
    }

    solution(0, 0, n);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();
  }
}
