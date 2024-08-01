import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 11507 카드셋트
  https://www.acmicpc.net/problem/11507
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();
    boolean[][] PKHT = new boolean[4][14];
    boolean GRESKA = false;
    for (int i = 0; i < input.length; i += 3) {
      char cardType = switch (input[i]) {
        case 'P' -> 0;
        case 'K' -> 1;
        case 'H' -> 2;
        case 'T' -> 3;
        default -> throw new IllegalArgumentException();
      }; // 카드 모양
      char num1 = (char) (input[i + 1] - '0');
      char num2 = (char) (input[i + 2] - '0');
      int cardNumber = (num1 * 10) + num2;
      if (PKHT[cardType][cardNumber]) {
        GRESKA = true;
        break;
      }
      PKHT[cardType][cardNumber] = true;
    }

    if (GRESKA) {
      System.out.println("GRESKA");
    } else {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < 4; i++) {
        int remain = 13;
        for (boolean b : PKHT[i]) {
          if (b) {
            remain--;
          }
        }

        result.append(remain).append(" ");
      }
      System.out.println(result);
    }
  }
}
