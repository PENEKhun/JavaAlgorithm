import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/*
  BAEKJOON 3613 Java vs C++
  https://www.acmicpc.net/problem/3613
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String variableName = br.readLine();
    boolean onlyLowerCase = variableName.replaceAll("[a-z]", "").isEmpty();
    boolean containUpperCase = variableName.replaceAll("[A-Z]", "").length() != variableName.length();
    boolean containUnderBar = variableName.contains("_");

    if ((containUnderBar && containUpperCase) || variableName.substring(0, 1).matches("[A-Z]") ||
    variableName.contains("__") || variableName.startsWith("_") || variableName.endsWith("_")) {
      System.out.println("Error!");
      return;
    }

    if (onlyLowerCase) {
      System.out.println(variableName);
      return;
    }

    boolean isCppStyle = containUnderBar;
    StringBuilder sb = new StringBuilder();
    if (isCppStyle) {
      String[] split = variableName.split("_");
      for (int i = 0; i < split.length; i++) {
        String s = split[i];
        if (i == 0) {
          sb.append(s);
          continue;
        }

        sb
            .append(String.valueOf(s.charAt(0)).toUpperCase(Locale.ROOT))
            .append(s.substring(1));
      }
    } else {
      // java style
      String[] split = variableName.split("");
      for (String s : split) {
        if (s.matches("[A-Z]")) {
          sb.append("_").append(s.toLowerCase());
        } else {
          sb.append(s);
        }
      }
    }

    System.out.println(sb);
  }
}