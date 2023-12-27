import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

/*
    BAEKJOON #18870 좌표 압축
    https://www.acmicpc.net/problem/18870
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] sorted = Arrays.stream(x).sorted().distinct().toArray();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < sorted.length; i++) {
      map.put(sorted[i], i);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < x.length; i++) {
      bw.write((map.get(x[i])) + "");

      if (i != x.length - 1)
        bw.write(" ");
    }

    bw.newLine();
    bw.close();
    br.close();
  }
}
