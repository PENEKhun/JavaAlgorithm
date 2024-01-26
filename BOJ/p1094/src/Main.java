import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
      BAEKJOON 1094 막대기
      https://www.acmicpc.net/problem/1094
*/

public class Main {

  public static int getSum(List<Integer> list) {
    int sum = 0;
    for (Integer i : list) {
      sum += i;
    }

    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    List<Integer> bars = new ArrayList<>();
    bars.add(64);

    while (true) {
      int sum = getSum(bars);
      if (sum <= x) {
        break;
      }

      int min = bars.stream().min(Comparator.naturalOrder()).get();
      bars.remove(bars.size() - 1);
      bars.add(min / 2);
      sum = getSum(bars);
      if (sum < x) {
        bars.add(min / 2);
      }
    }

    System.out.println(bars.size());
  }
}
