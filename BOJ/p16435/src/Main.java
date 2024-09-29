import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 16435 스네이크버드
  https://www.acmicpc.net/problem/16435
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NL = br.readLine().split(" ");
    int N = Integer.parseInt(NL[0]); // 과일의 개수
    int L = Integer.parseInt(NL[1]); // 초기 길이

    int idx = 0;
    int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(heights);
    while (true) {
      if (idx >= heights.length) {
        break;
      }

      if (L >= heights[idx]) {
        L++;
        idx++;
      } else {
        break;
      }
    }

    System.out.println(L);
  }
}
