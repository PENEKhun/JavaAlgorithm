/*
    BAEKJOON 1431 시리얼 번호
    https://www.acmicpc.net/problem/1431
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static int sumNum(String str) {
    try {
      return Arrays.stream(str.replaceAll("[A-Z]", "")
                      .split(""))
              .mapToInt(Integer::parseInt)
              .sum();
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<String> dicts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      dicts.add(br.readLine());
    }

    dicts.sort((String s1, String s2) -> {
      if (s1.length() != s2.length())
        return s1.length() - s2.length();

      int s1Sum = sumNum(s1);
      int s2Sum = sumNum(s2);
      if (s1Sum != s2Sum)
        return s1Sum - s2Sum;

      char[] s1Chars = s1.toCharArray();
      char[] s2Chars = s2.toCharArray();

      for (int i = 0; i < s1Chars.length; i++) {
          if (s1Chars[i] != s2Chars[i])
            return s1Chars[i] - s2Chars[i];
      }

      return 0;
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (String dict : dicts) {
      bw.write(dict + "\n");
    }
    bw.flush();
    bw.close();
  }
}
