import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 11728 배열 합치기
  https://www.acmicpc.net/problem/11728
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] AB = new int[NM[0] + NM[1]];
    String[] aInput = br.readLine().split(" ");
    for (int i = 0; i < aInput.length; i++) {
      AB[i] = Integer.parseInt(aInput[i]);
    }

    String[] bInput = br.readLine().split(" ");
    for (int i = 0; i < bInput.length; i++) {
      AB[i + NM[0]] = Integer.parseInt(bInput[i]);
    }

    Arrays.sort(AB);
    StringBuilder sb = new StringBuilder();
    for (long l : AB) {
      sb.append(l).append(" ");
    }
    bw.write(String.valueOf(sb));
    bw.newLine();
    bw.flush();
  }
}
