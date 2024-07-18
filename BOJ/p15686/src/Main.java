import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  BAEKJOON 15686 치킨 배달
  https://www.acmicpc.net/problem/15686
*/

public class Main {
  static final int EMPTY = 0;
  static final int HOUSE = 1;
  static final int CHICKEN = 2;
  static int[][] map;
  static int n;
  static int m;
  static int result = Integer.MAX_VALUE;
  static List<Position> chickenPos = new ArrayList<>();
  static List<Position> housePos = new ArrayList<>();

  static class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static void calculateChickenDistance(List<Position> selectedChickens) {
    int cityChickenSum = 0;
    for (Position house : housePos) {
      int houseChickenMin = Integer.MAX_VALUE;
      for (Position chicken : selectedChickens) {
        houseChickenMin = Math.min(houseChickenMin, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
      }
      cityChickenSum += houseChickenMin;
    }
    result = Math.min(result, cityChickenSum);
  }

  static void generateCombinations(int start, List<Position> selectedChickens) {
    if (selectedChickens.size() == m) {
      calculateChickenDistance(selectedChickens);
      return;
    }

    for (int i = start; i < chickenPos.size(); i++) {
      selectedChickens.add(chickenPos.get(i));
      generateCombinations(i + 1, selectedChickens);
      selectedChickens.remove(selectedChickens.size() - 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] NM = br.readLine().split(" ");
    n = Integer.parseInt(NM[0]);
    m = Integer.parseInt(NM[1]);
    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int k = 0; k < line.length; k++) {
        map[i][k] = line[k];
        if (line[k] == CHICKEN) {
          chickenPos.add(new Position(k, i));
        } else if (line[k] == HOUSE) {
          housePos.add(new Position(k, i));
        }
      }
    }

    generateCombinations(0, new ArrayList<>());
    System.out.println(result);
  }
}
