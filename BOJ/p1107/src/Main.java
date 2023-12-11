import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1107 리모컨
    url : https://www.acmicpc.net/problem/1107
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int channel = Integer.parseInt(br.readLine());
    int buttonBrokenCount = Integer.parseInt(br.readLine());
    boolean[] buttonBrokenState = new boolean[10];

    int[] splitBroken;
    if (buttonBrokenCount != 0) {
      splitBroken = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int i : splitBroken) {
        buttonBrokenState[i] = true;
      }
    }

    int min = Math.abs(channel - 100);
    for (int i = 999_999; i >= 0; i--) {
      // check broken include
      boolean pass = true;
      for (char c : String.valueOf(i).toCharArray()) {
        if (buttonBrokenState[Integer.parseInt(String.valueOf(c))]) {
          pass = false;
        }
      }
      if (pass) {
        min = Math.min((Math.abs(channel - i) + String.valueOf(i).length()), min);
      }
    }

    bw.write(min + "\n");
    bw.flush();
    bw.close();
  }
}
