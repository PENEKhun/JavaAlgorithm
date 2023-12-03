import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1074 Z
    url : https://www.acmicpc.net/problem/1074
*/

public class Main {

  public static int calc(int n, int row, int col) {
    if (n <= 1) {
      return 0;
    }

    n /= 2;

    boolean left = (col < n);
    boolean right = !left;
    boolean top = (row < n);

    // 1사
    if (left && top) {
      return calc(n, row, col);
    }
    // 2사
    else if (right && top) {
      return (int) Math.pow(n, 2) + calc(n, row, col - n);
    }
    // 3사
    else if (left) {
      return (int) Math.pow(n, 2) * 2 + calc(n, row - n, col);

    }
    // 4사
    else {
      return (int) Math.pow(n, 2) * 3 + calc(n, row - n, col - n);
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splitInput = br.readLine().split(" ");
    int N = Integer.parseInt(splitInput[0]);
    int row = Integer.parseInt(splitInput[1]);
    int col = Integer.parseInt(splitInput[2]);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(calc((int) Math.pow(2, N), row, col) + "\n");
    bw.flush();
    bw.close();
  }
}
