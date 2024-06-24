import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 2217 로프
  https://www.acmicpc.net/problem/2217
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ropes = new int[n];
    for (int i = 0; i < n; i++) {
      ropes[i] = Integer.parseInt(br.readLine());
    }

    // 로프를 안쓰는 경우도 있을듯
    Arrays.sort(ropes);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int val = ropes[i] * (n - i);
      max = Math.max(val, max);
    }

    System.out.println(max);
  }
}