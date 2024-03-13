import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  BAEKJOON 15654 N과 M (5)
  https://www.acmicpc.net/problem/15654
*/

public class Main {

  static StringBuilder result = new StringBuilder();

  static void combi(int[] n, int r, List<Integer> chosen) {
    if (chosen.size() == r) {
      String toPrint = chosen.toString();
      result.append(
          toPrint.replaceAll(", ", " ").substring(1).replace("]", "\n"));

      return;
    }

    for (int i = 0; i < n.length; i++) {
      if (chosen.contains(n[i])) {
        continue;
      }

      chosen.add(n[i]);
      combi(n, r, chosen);
      chosen.remove(chosen.size() - 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int n = input[0];
    int m = input[1];
    int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

    combi(numbers, m, new ArrayList<>());
    System.out.print(result);
  }
}