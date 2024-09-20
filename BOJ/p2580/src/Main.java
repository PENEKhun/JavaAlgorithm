import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 2580 스도쿠
  https://www.acmicpc.net/problem/2580
*/

public class Main {
  static boolean[][] row = new boolean[10][10];
  static boolean[][] col = new boolean[10][10];
  static boolean[][] square = new boolean[10][10];
  static int[][] board = new int[10][10];
  static StringBuilder result = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int y = 1; y <= 9; y++) {
      String[] input = br.readLine().split(" ");
      for (int x = 0; x < input.length; x++) {
        int val = Integer.parseInt(input[x]);
        board[y][x + 1] = val;
        if (val != 0) {
          row[y][val] = col[x + 1][val] = square[squareIdxCalc(x + 1, y)][val] = true;
        }
      }
    }
    solution(1, 1);
    System.out.printf(String.valueOf(result));
  }
  private static boolean solution(int x, int y) {
    if (y == 10) {
      printBoard();
      return true;
    }
    if (x == 10) {
      return solution(1, y + 1);
    }
    if (board[y][x] != 0) {
      return solution(x + 1, y);
    }
    for (int num = 1; num <= 9; num++) {
      if (!row[y][num] && !col[x][num] && !square[squareIdxCalc(x, y)][num]) {
        board[y][x] = num;
        row[y][num] = col[x][num] = square[squareIdxCalc(x, y)][num] = true;
        if (solution(x + 1, y)) return true;
        board[y][x] = 0;
        row[y][num] = col[x][num] = square[squareIdxCalc(x, y)][num] = false;
      }
    }
    return false;
  }
  private static void printBoard() {
    for (int row = 1; row <= 9; row++) {
      for (int col = 1; col <= 9; col++) {
        result.append(board[row][col]).append(" ");
      }
      result.append("\n");
    }
  }
  private static int squareIdxCalc(int x, int y) {
    int row = (y - 1) / 3;
    int col = (x - 1) / 3;
    return row * 3 + col + 1;
  }
}
