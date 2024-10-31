import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 7682 틱택토
  https://www.acmicpc.net/problem/7682
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();
    while (true) {
      String input = br.readLine();
      if ("end".equals(input)) {
        break;
      }

      if (isValid(input)) {
        result.append("valid").append("\n");
      } else {
        result.append("invalid").append("\n");
      }
    }

    System.out.print(result);
  }

  private static boolean isValid(String game) {
    int oSize = game.length() - game.replace("O", "").length();
    int xSize = game.length() - game.replace("X", "").length();

    boolean xWin = winWith('X', game);
    boolean oWin = winWith('O', game);
    boolean ox = (!xWin && !oWin);
    boolean allDone = !game.contains(".");
    if (xWin && oWin) {
      return false;
    }

    if (xWin && xSize == oSize + 1) {
      return true;
    } else if (oWin && oSize == xSize) {
      return true;
    } else if (ox && xSize == oSize + 1 && allDone) {
      return true;
    }

    return false;
  }

  private static boolean winWith(char target, String game) {
    // 가로 3줄
    if (game.charAt(0) == target && game.charAt(1) == target && game.charAt(2) == target) {
      return true;
    }

    if (game.charAt(3) == target && game.charAt(4) == target && game.charAt(5) == target) {
      return true;
    }

    if (game.charAt(6) == target && game.charAt(7) == target && game.charAt(8) == target) {
      return true;
    }

    // 세로 3개
    if (game.charAt(0) == target && game.charAt(3) == target && game.charAt(6) == target) {
      return true;
    }

    if (game.charAt(1) == target && game.charAt(4) == target && game.charAt(7) == target) {
      return true;
    }

    if (game.charAt(2) == target && game.charAt(5) == target && game.charAt(8) == target) {
      return true;
    }

    // 대각선 \
    if (game.charAt(0) == target && game.charAt(4) == target && game.charAt(8) == target) {
      return true;
    }

    // 대각선 /
    if (game.charAt(2) == target && game.charAt(4) == target && game.charAt(6) == target) {
      return true;
    }
    return false;
  }
}
