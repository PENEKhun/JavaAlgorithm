import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 12865 평범한 배낭
  https://www.acmicpc.net/problem/12865
*/

public class Main {

  public static class Item {

    public int weight;
    public int worthy;

    public Item(int weight, int worthy) {
      this.weight = weight;
      this.worthy = worthy;
    }

    @Override
    public String toString() {
      return "Item{" +
          "weight=" + weight +
          ", worthy=" + worthy +
          '}';
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int maxKg = Integer.parseInt(input[1]);

    Item[] items = new Item[n];
    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      items[i] = new Item(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    }

    int[][] dp = new int[n + 1][maxKg + 1];
    for (int i = 1; i <= n; i++) {
      for (int w = 1; w <= maxKg; w++) {
        Item item = items[i - 1];
        if (item.weight > w) {
          dp[i][w] = dp[i - 1][w];
        } else {
          dp[i][w] = Math.max(
              dp[i - 1][w - item.weight] + item.worthy,
              dp[i - 1][w]
          );
        }
      }
    }

    System.out.println(dp[n][maxKg]);
  }
}