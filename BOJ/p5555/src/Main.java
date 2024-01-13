import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
      BAEKJOON 5555 반지
      https://www.acmicpc.net/problem/5555
*/


public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String toFind = br.readLine();
    int n = Integer.parseInt(br.readLine());
    int result = 0;
    for (int i=0; i<n; i++){
      String input = br.readLine().repeat(2);
      if (input.contains(toFind)) {
        result++;
      }
    }
    System.out.println(result);

  }
}
