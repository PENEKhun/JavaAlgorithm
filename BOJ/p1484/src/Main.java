import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 1484 다이어트
  https://www.acmicpc.net/problem/1484
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int x = 1;
    int y = 1;
    // g = 성원이의 현재 몸무게 ^ 2 - 기억하고 있던 몸무게 ^ 2
    int g = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    do {
      int compare = Double.compare(Math.pow(x, 2), Math.pow(y, 2) + g);
      boolean lastIncreasedX = false;
      if (compare == 0) {
        result.append(x).append("\n");
        if (lastIncreasedX) {
          y++;
        } else {
          x++;
        }
      } else if (compare < 0) {
        lastIncreasedX = true;
        x++;
      } else {
        lastIncreasedX = false;
        y++;
      }

    } while (x < g);

    if (result.isEmpty()) {
      result.append("-1\n");
    }

    bw.write(String.valueOf(result));
    bw.flush();
  }
}