import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 20529 가장 가까운 세 사람의 심리적 거리
  https://www.acmicpc.net/problem/20529
*/

public class Main {

  public static int getDistance(String a, String b, String c) {
    int distance = getDistance(a, b);
    distance += getDistance(b, c);
    distance += getDistance(a, c);

    return distance;
  }

  private static int getDistance(String a, String b) {
    int distance = 0;

    if (a.charAt(0) != b.charAt(0)) {
      distance += 1;
    }

    if (a.charAt(1) != b.charAt(1)) {
      distance += 1;
    }

    if (a.charAt(2) != b.charAt(2)) {
      distance += 1;
    }

    if (a.charAt(3) != b.charAt(3)) {
      distance += 1;
    }
    return distance;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tCase = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    for (int t = 0; t < tCase; t++) {
      int n = Integer.parseInt(br.readLine());
      String[] students = br.readLine().split(" ");

      int score = Integer.MAX_VALUE;
      if (n >= 33) {
        result.append("0\n");
        continue;
      }

      loop:
      for (int i = 0; i < n; i++) {
        for (int k = i + 1; k < n; k++) {
          for (int j = k + 1; j < n; j++) {
            score = Math.min(score, getDistance(students[i], students[k], students[j]));
            if (score == 0) {
              break loop;
            }
          }
        }
      }

      result.append(score).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();
  }
}