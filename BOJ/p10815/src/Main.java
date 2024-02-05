import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

/*
      BAEKJOON 10815 숫자 카드
      https://www.acmicpc.net/problem/10815
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    String[] have = br.readLine().split(" ");
    HashSet<String> db = new HashSet<>(Arrays.asList(have));

    br.readLine();
    String[] toCheck = br.readLine().split(" ");
    StringBuilder sb = new StringBuilder();
    for (String s : toCheck) {
      sb.append(
          db.contains(s) ? "1 " : "0 "
      );
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString() + "\n");
    bw.flush();
  }
}
