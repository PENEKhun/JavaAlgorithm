import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 1213 팰린드롬 만들기
  https://www.acmicpc.net/problem/1213
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String before = br.readLine();
    bw.write(solution(before) + "\n");
    bw.flush();
  }

  private static String solution(String before) {
    int length = before.length();
    int[] alphabetCnt = new int['a' - 'A'];
    before.chars().forEach(c -> alphabetCnt[c - 'A']++);

    StringBuilder sb = new StringBuilder();
    String delimiter = null;
    while (length != 0) {
      for (int i = 0; i < alphabetCnt.length; i++) {
        if (alphabetCnt[i] == 1) {
          if (delimiter != null) {
            return "I'm Sorry Hansoo";
          } else {
            delimiter = String.valueOf((char) (i + 'A'));
            length--;
            alphabetCnt[i]--;
          }
        }

        int cnt = alphabetCnt[i] / 2;
        for (int j = 0; j < cnt; j++) {
          sb.append((char) (i + 'A'));
          length -= 2;
          alphabetCnt[i] -= 2;
        }
      }
    }

    StringBuilder reversed = new StringBuilder(sb).reverse();
    if (delimiter != null) {
      sb.append(delimiter);
    }
    sb.append(reversed);
    return String.valueOf(sb);
  }
}