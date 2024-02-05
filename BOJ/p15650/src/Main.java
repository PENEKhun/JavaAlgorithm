import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
      BAEKJOON 15650 N과 M (2)
      https://www.acmicpc.net/problem/15650
*/

public class Main {

  static int n;
  static int m;
  static int[] arr;
  static StringBuilder result = new StringBuilder();

  public static int[] appendArr(int[] arr, int item) {
    int[] result = Arrays.copyOf(arr, arr.length + 1);
    result[arr.length] = item;
    return result;
  }

  public static void solution(int index, int[] picked) {
    if (picked.length == m) {
      result.append(Arrays.stream(picked).mapToObj(Integer::toString).reduce((a, b) -> a + " " + b).get())
          .append("\n");
    }

    for (int i = index; i <= n; i++) {
      solution(i + 1, appendArr(picked, i));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]); // 최대 수
    m = Integer.parseInt(input[1]); // m개 뽑기
    arr = new int[m];
    // 한번씩 순서대로 뽑기
    solution(1, new int[] {});
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(result.toString());
    bw.flush();
  }
}

