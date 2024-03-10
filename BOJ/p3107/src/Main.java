import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 3107 IPv6
  https://www.acmicpc.net/problem/3107
*/

public class Main {

  public static String paddingZero(String original) {
    int diff = 4 - original.length();
    return "0".repeat(diff) + original;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ipv6 = br.readLine();
    String[] parts = new String[8];

    int maxColon = 8;
    if (ipv6.contains("::")) {
      String[] split = ipv6.split("::");
      int colonCnt = ipv6.split(":").length - split.length;
      int diff = maxColon - colonCnt;
      String append = ":";
      if (split[0].isEmpty()) {
        append = "0000" + append;
      }

      ipv6 = ipv6.replace("::", append.repeat(diff));
    }

    parts = ipv6.split(":");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      if (parts.length <= i) {
        sb.append("0000");
      } else {
        sb.append(paddingZero(parts[i]));
      }

      if (i != 7) {
        sb.append(":");
      }
    }

    System.out.println(sb);
  }
}