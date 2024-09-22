import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 14500 테트로미노
  https://www.acmicpc.net/problem/14500
*/


public class Main {
  static int[][] paper;
  static int result;
  static int[][][] shapes = {
      {{1, 1, 1, 1}},
      {{1, 1}, {1, 1}},
      {{1, 0}, {1, 0}, {1, 1}},
      {{1, 0}, {1, 1}, {0, 1}},
      {{1, 1, 1}, {0, 1, 0}}
  };

  public static int calcScore(int startX, int startY, int[][] shape) {
    int shapeWidth = shape[0].length;
    int shapeHeight = shape.length;

    if (startX + shapeWidth > paper[0].length || startY + shapeHeight > paper.length) {
      return -1;
    }

    int score = 0;
    for (int y = 0; y < shapeHeight; y++) {
      for (int x = 0; x < shapeWidth; x++) {
        if (shape[y][x] == 1) {
          score += paper[startY + y][startX + x];
        }
      }
    }
    return score;
  }

  public static int[][] rotate(int[][] shape) {
    int height = shape.length;
    int width = shape[0].length;
    int[][] rotated = new int[width][height];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        rotated[j][height - 1 - i] = shape[i][j];
      }
    }
    return rotated;
  }

  public static int[][] flip(int[][] shape) {
    int height = shape.length;
    int width = shape[0].length;
    int[][] flipped = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        flipped[i][width - 1 - j] = shape[i][j];
      }
    }
    return flipped;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] YX = br.readLine().split(" ");
    int Y = Integer.parseInt(YX[0]);
    int X = Integer.parseInt(YX[1]);

    paper = new int[Y][];
    for (int y = 0; y < Y; y++) {
      paper[y] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int y = 0; y < Y; y++) {
      for (int x = 0; x < X; x++) {
        for (int[][] shape : shapes) {
          checkAllTransformations(x, y, shape);
        }
      }
    }

    System.out.println(result);
  }

  private static void checkAllTransformations(int x, int y, int[][] shape) {
    int[][] currentShape = shape;
    for (int i = 0; i < 4; i++) {
      result = Math.max(result, calcScore(x, y, currentShape));
      currentShape = rotate(currentShape);
    }

    currentShape = flip(shape);
    for (int i = 0; i < 4; i++) {
      result = Math.max(result, calcScore(x, y, currentShape));
      currentShape = rotate(currentShape);
    }
  }
}
