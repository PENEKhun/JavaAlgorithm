import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
  BAEKJOON 2036 수열의 점수
  https://www.acmicpc.net/problem/2036
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> negative = new ArrayList<>();
    List<Integer> positive = new ArrayList<>();
    int zeroCount = 0;
    for (int i = 0; i < n; i++) {
      int newNum = Integer.parseInt(br.readLine());
      if (newNum == 0) {
        zeroCount++;
      } else if (newNum > 0) {
        positive.add(newNum);
      } else {
        negative.add(newNum);
      }
    }
    Collections.sort(positive, Collections.reverseOrder());
    Collections.sort(negative);

    long result = 0;

    // 양수 관리
    while (!positive.isEmpty()) {
      if (positive.size() == 1) {
        result += positive.get(0);
        break;
      }
      int first = positive.remove(0);
      int second = positive.remove(0);
      if (first == 1 || second == 1) {
        result += first + second;
      } else {
        result += (long) first * second;
      }
    }

    // 0 관리
    while (zeroCount != 0 && !negative.isEmpty()) {
      if (negative.size() % 2 != 0) {
        negative.remove(negative.size() - 1);
      }
      zeroCount--;
    }

    // 음수 관리
    while (negative.size() >= 2) {
      int first = negative.remove(0);
      int second = negative.remove(0);
      result += (long) first * second;
    }
    if (!negative.isEmpty()) {
      result += negative.get(0);
    }

    System.out.println(result);
  }
}
