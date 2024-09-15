import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  BAEKJOON 1158 요세푸스 문제
  https://www.acmicpc.net/problem/1158
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    List<Integer> people = new ArrayList<>();
    StringBuilder sb = new StringBuilder("<");
    for (int i = 1; i <= N; i++) {
      people.add(i);
    }

    int idx = K - 1;
    while (!people.isEmpty()) {
      if (idx >= people.size()) {
        idx %= people.size();
      }
      sb.append(people.get(idx));
      people.remove(idx);
      if (!people.isEmpty()) {
        sb.append(", ");
      }
      idx += K - 1;
    }
    sb.append(">");

    System.out.println(sb);
  }
}
