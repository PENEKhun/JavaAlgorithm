import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/*
  BAEKJOON 14889 스타트와 링크
  https://www.acmicpc.net/problem/14889
*/

public class Main {
  static int result = Integer.MAX_VALUE;
  static int N; // 사람 수
  static int[][] S; // 시너지
  static HashSet<Integer> teamA = new HashSet<>();

  public static int calcDiff() {
    int scoreA = 0;
    int scoreB = 0;

    for (Integer i : teamA) {
      for (int k = 0; k < N; k++) {
        if (teamA.contains(k)) {
          scoreA += S[i][k];
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (teamA.contains(i)) continue;
      for (int k = 0; k < N; k++) {
        if (teamA.contains(k)) continue;
        scoreB += S[i][k];
      }
    }

    return Math.abs(scoreA - scoreB);
  }

  public static void dfs(int idx) {
    if (teamA.size() > N / 2) {
      return;
    }

    if (teamA.size() == N / 2) {
      result = Math.min(result, calcDiff());
      return;
    }

    for (int i = idx; i < N; i++) {
      teamA.add(i);
      dfs(i + 1);
      teamA.remove(i);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    S = new int[N][N];
    for (int i = 0; i < N; i++) {
      S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    dfs(0);
    System.out.println(result);
  }
}
