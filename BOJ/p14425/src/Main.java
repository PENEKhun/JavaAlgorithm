import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/*
  BAEKJOON 14425 문자열 집합
  https://www.acmicpc.net/problem/14425
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    HashSet<String> db = new HashSet<>();
    for (int i = 0; i < n; i++) {
      db.add(br.readLine());
    }

    int result = 0;
    for (int i = 0; i < m; i++) {
      if (db.contains(br.readLine()))
        result++;
    }

    System.out.println(result);
  }
}