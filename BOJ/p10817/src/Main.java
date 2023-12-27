import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    BAEKJOON #10817 세 수
    https://www.acmicpc.net/problem/10817
*/

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted()
        .toArray();

    System.out.println(abc[1]);
  }
}
