import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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

    items = Arrays.stream(items).sorted(Comparator.comparingInt(o -> o.weight)).toArray(Item[]::new);
    System.out.println(Arrays.toString(items));
    ArrayList<Item> bag = new ArrayList<>();
    int[] dp = new int[maxKg + 1];
    for (Item item : items) {
      System.out.println(Arrays.toString(dp));
      bag.add(item);

      for (int kg = 1; kg <= maxKg; kg++) {
//        if (kg >= item.weight) {
//          dp[kg] = Math.max(dp[kg - 1], bag.getLast().worthy);
//        }
      }
    }

    System.out.println(Arrays.toString(dp));
    System.out.println(dp[maxKg - 1]);
  }
}