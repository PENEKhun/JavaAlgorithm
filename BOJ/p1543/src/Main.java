import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1543 문서 검색
  https://www.acmicpc.net/problem/1543
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String document = br.readLine();
    String search = br.readLine();
    int n = 0;
    while (document.contains(search)) {
      document = document.replaceFirst(search, "#");
      n++;
    }

    System.out.println(n);
  }
}