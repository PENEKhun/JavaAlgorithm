import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 10867 중복 빼고 정렬하기
  https://www.acmicpc.net/problem/10867
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().sorted().toArray();

    StringBuilder sb = new StringBuilder();
    for (int num : a) {
      sb.append(num).append(" ");
    }

    System.out.println(sb);
  }
}