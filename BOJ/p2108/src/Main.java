import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map.Entry;

/*
  BAEKJOON 2108 통계학
  https://www.acmicpc.net/problem/2108
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 홀수
    int[] numbers = new int[N];
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Arrays.sort(numbers);
    IntSummaryStatistics stat = Arrays.stream(numbers).summaryStatistics();
    // 산술 평균 (첫자리 반올림)
    bw.write(Math.round(stat.getAverage()) + "\n");
    // 중앙 값
    bw.write(numbers[N / 2] + "\n");
    // 최빈 값
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int number : numbers) {
      map.put(
          number,
          map.getOrDefault(number, 0) + 1
      );
    }

    int[][] newNum = new int[map.size()][2];
    int i = 0;
    for (Entry<Integer, Integer> kv : map.entrySet()) {
      newNum[i] = new int[] {kv.getKey(), kv.getValue()};
      i++;
    }
    Arrays.sort(newNum, (a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      }
      return b[1] - a[1];
    });

    if (map.size() > 1 && newNum[0][1] == newNum[1][1]) {
      bw.write(newNum[1][0] + "\n");
    } else {
      bw.write(newNum[0][0] + "\n");
    }

    // 범위 (최댓값과 최솟값 차이)
    bw.write(stat.getMax() - stat.getMin() + "\n");
    bw.flush();
  }
}