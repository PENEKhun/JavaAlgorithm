import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

/*
  BAEKJOON 15666 N과 M (12)
  https://www.acmicpc.net/problem/15666
*/

public class Main {

  static LinkedHashSet<String> result = new LinkedHashSet<>();
  static int[] numbers;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

    combination(0, 0, new int[M]);

    for (String txt : result) {
      System.out.print(txt);
    }
  }

  // 재귀를 통한 조합 생성 메소드
  public static void combination(int start, int depth, int[] picked) {
    if (depth == M) {
      StringBuilder sb = new StringBuilder();
      for (int num : picked) {
        sb.append(num).append(" ");
      }
      result.add(sb.toString().trim() + "\n");
      return;
    }

    for (int i = start; i < N; i++) {
      picked[depth] = numbers[i];
      combination(i, depth + 1, picked);
    }
  }
}
