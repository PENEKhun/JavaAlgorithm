import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
      BAEKJOON 17176 암호해독기
      https://www.acmicpc.net/problem/17176
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine(); // ignore

    HashMap<String, Integer> table = new HashMap<>();
    table.put(" ", 0);
    for (int i = 1; i <= 26; i++) {
      table.put(Character.toString(i + 64), i);
    }
    for (int i = 27; i <= 52; i++) {
      table.put(Character.toString(i + 70), i);
    }

    int[] crypto = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).sorted().toArray();
    List<Integer> plain = Arrays.stream(br.readLine().split(""))
        .map(table::get).sorted().collect(Collectors.toList());

    boolean err = false;
    for (int i = 0; i < crypto.length; i++) {
      int a = crypto[i];
      int b = plain.get(i);
      if (!Objects.equals(a, b)) {
        err = true;
        break;
      }
    }

    if (err) {
      System.out.println("n");
    } else {
      System.out.println("y");
    }
  }
}
