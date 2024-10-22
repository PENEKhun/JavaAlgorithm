import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
  BAEKJOON 9237 이장님 초대
  https://www.acmicpc.net/problem/9237
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 묘목의 수
    Integer[] trees = Arrays.stream(br.readLine().split(" "))
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
    Arrays.sort(trees, (o1, o2) -> o2 - o1);

    int ans = 2;
    for (int i=0; i<N; i++) {
      int days = i + 1;
      ans = Math.max(ans, days + trees[i] + 1);
    }

    System.out.println(ans);
  }
}
