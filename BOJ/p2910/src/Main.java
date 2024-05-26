import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

/*
  BAEKJOON 2910 빈도 정렬
  https://www.acmicpc.net/problem/2910
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 코드를 작성하세요.
    String[] inputs = br.readLine().split(" ");
    HashMap<Integer, Integer> frequent = new HashMap<>();
    HashMap<Integer, Integer> order = new HashMap<>();
    int len = Integer.parseInt(inputs[0]);
    int maxNum = Integer.parseInt(inputs[1]);

    Integer[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    int orderNumbering = 1;
    for (int num : in) {
      if (!frequent.containsKey(num)) {
        order.put(num, orderNumbering);
        orderNumbering++;
      }

      frequent.put(
          num,
          frequent.getOrDefault(num, 0) + 1
      );
    }

    StringBuilder result = new StringBuilder();
    Arrays.sort(in,
        (a, b) -> {
          int frequentDiff = frequent.get(b) - frequent.get(a);
          if (frequentDiff != 0) {
            return frequentDiff;
          }

          return order.get(a) - order.get(b);
        });

    for (Integer i : in) {
      result.append(i).append(" ");
    }

    bw.write(String.valueOf(result));
    bw.flush();
  }
}