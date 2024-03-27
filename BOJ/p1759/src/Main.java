import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;

/*
  BAEKJOON 1759 암호 만들기
  https://www.acmicpc.net/problem/1759
*/

public class Main {

  static int l, c;
  static String[] words;
  static LinkedHashSet<String> result = new LinkedHashSet<>();

  public static void find(int idx, StringBuilder parts, int[] partsInformation) {
    StringBuilder sb = new StringBuilder(parts);

    if (sb.length() == l) {
      if (partsInformation[0] >= 1 && partsInformation[1] >= 2) {
        result.add(String.valueOf(sb));
      } else {
        return;
      }
    }

    for (int i = idx + 1; i < words.length; i++) {
      String s = words[i];
      boolean isAioue = isAioue(s);
      int subAioue = partsInformation[0] + (isAioue ? 1 : 0);
      int subMoum = partsInformation[1] + (isAioue ? 0 : 1);

      find(i, new StringBuilder(sb).append(s),
          new int[] {subAioue, subMoum});
    }
  }

  public static boolean isAioue(String s) {
    return s.equals("a") || s.equals("i") || s.equals("o") || s.equals("u") || s.equals("e");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    l = Integer.parseInt(input[0]); // 뽑을 수
    c = Integer.parseInt(input[1]); // 단어 목록 수
    words = br.readLine().split(" ");
    Arrays.sort(words);

    for (int k = 0; k < words.length; k++) {
      String s = words[k];
      find(k, new StringBuilder().append(s), new int[] {isAioue(s) ? 1 : 0, isAioue(s) ? 0 : 1});
    }

    StringBuilder print = new StringBuilder();
    for (String s : result) {
      print.append(s).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(print));
    bw.flush();
  }
}