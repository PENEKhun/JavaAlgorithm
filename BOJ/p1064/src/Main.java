import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;

/*
      BAEKJOON 1064 평행사변형
      https://www.acmicpc.net/problem/1064
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    ArrayList<Position> positions = new ArrayList<>();
    positions.add(new Position(input[0], input[1]));
    positions.add(new Position(input[2], input[3]));
    positions.add(new Position(input[4], input[5]));

    if (positions.get(0).x == positions.get(1).x && positions.get(1).x == positions.get(2).x ||
        positions.get(0).y == positions.get(1).y && positions.get(1).y == positions.get(2).y) {
      System.out.println("-1.0");
      return;
    }

    ArrayList<BigDecimal> len = new ArrayList<>();
    len.add(
        BigDecimal.valueOf((Math.pow((Math.abs(
            positions.get(0).x - positions.get(1).x
        )), 2) +
            Math.pow((Math.abs(
                positions.get(0).y - positions.get(1).y
            )), 2)))
    );

    len.add(
        BigDecimal.valueOf((Math.pow((Math.abs(
            positions.get(0).x - positions.get(2).x
        )), 2) +
            Math.pow((Math.abs(
                positions.get(0).y - positions.get(2).y
            )), 2)))
    );

    len.add(
        BigDecimal.valueOf((Math.pow((Math.abs(
            positions.get(1).x - positions.get(2).x
        )), 2) +
            Math.pow((Math.abs(
                positions.get(1).y - positions.get(2).y
            )), 2)))
    );

    len.sort(BigDecimal::compareTo);

    BigDecimal min = len.get(0).sqrt(MathContext.DECIMAL64)
        .add(len.get(1).sqrt(MathContext.DECIMAL64)).multiply(BigDecimal.valueOf(2));
    BigDecimal max = len.get(1).sqrt(MathContext.DECIMAL64)
        .add(len.get(2).sqrt(MathContext.DECIMAL64)).multiply(BigDecimal.valueOf(2));

    if (len.get(0).sqrt(MathContext.DECIMAL64).add(len.get(1).sqrt(MathContext.DECIMAL64))
        .compareTo(len.get(2).sqrt(MathContext.DECIMAL64)) <= 0) {
      System.out.println("-1.0");
    } else {
      System.out.println(max.subtract(min));
    }
  }

  public static class Position {

    public double x;
    public double y;

    public Position(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Position{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
