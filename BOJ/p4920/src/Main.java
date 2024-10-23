import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 4920 테트리스 게임
  https://www.acmicpc.net/problem/4920
*/

public class Main {
  static int[][][] blocks = new int[][][] {
      // 일자 블록
      {
          {1, 1, 1, 1}
      },
      // 두번째 블록 (번개 모양)
      {
          {1, 1, 0},
          {0, 1, 1}
      },
      // 세번째 블록 (L자 모양)
      {
          {1, 1, 1},
          {0, 0, 1}
      },
      // 네번째 블록 (T자 모양)
      {
          {1, 1, 1},
          {0, 1, 0}
      },
      // 다섯번째 블록 (정사각형)
      {
          {1, 1},
          {1, 1}
      }
  };

  public static int[][] rotate(int[][] block) {
    int newHeight = block[0].length;
    int newWidth = block.length;

    int[][] newBlock = new int[newHeight][newWidth];
    for (int y = 0; y < block.length; y++) {
      for (int x = 0; x < block[0].length; x++) {
        newBlock[x][newWidth - y - 1] = block[y][x];
      }
    }
    return newBlock;
  }

  public static int calcMaxSum(int[][] block, int[][] board) {
    int blockWidth = block[0].length;
    int blockHeight = block.length;
    int boardSize = board.length;

    int maxSum = Integer.MIN_VALUE;
    for (int y = 0; y <= boardSize - blockHeight; y++) {
      for (int x = 0; x <= boardSize - blockWidth; x++) {
        int sum = 0;
        for (int i = 0; i < blockHeight; i++) {
          for (int j = 0; j < blockWidth; j++) {
            if (block[i][j] == 1) {
              sum += board[y + i][x + j];
            }
          }
        }
        maxSum = Math.max(maxSum, sum);
      }
    }
    return maxSum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int testCaseNumber = 1;
    StringBuilder result = new StringBuilder();

    while (true) {
      String input = br.readLine().trim();
      int N = Integer.parseInt(input);

      if (N == 0) {
        break;
      }

      int[][] matrix = new int[N][N];
      for (int i = 0; i < N; i++) {
        line = br.readLine();
        String[] row = line.trim().split("\\s+");
        for (int j = 0; j < N; j++) {
          matrix[i][j] = Integer.parseInt(row[j]);
        }
      }

      int ans = Integer.MIN_VALUE;
      for (int[][] block : blocks) {
        for (int i = 0; i < 4; i++) {
//          System.out.println(Arrays.deepToString(block));
          ans = Math.max(ans, calcMaxSum(block, matrix));
          block = rotate(block);
        }
      }

      result.append("%d. %d".formatted(testCaseNumber++, ans)).append("\n");
    }

    System.out.print(result);
  }
}
