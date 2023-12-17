import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1032 명령 프롬프트
    url : https://www.acmicpc.net/problem/1032
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[][] files = new String[n][];
    for (int i = 0; i < n; i++) {
      files[i] = br.readLine().split("");
    }

    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < files[0].length; k++) {
      boolean same = true;
      for (int i = 1; i < n; i++) {
        if (!Objects.equals(files[i][k], files[i - 1][k])) {
          same = false;
          break;
        }
      }

      if (same) {
        sb.append(files[0][k]);
      } else {
        sb.append("?");
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString() + "\n");
    bw.flush();
    bw.close();
  }
}
