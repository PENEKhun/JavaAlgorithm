import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
      BAEKJOON 11052 카드 구매하기
      https://www.acmicpc.net/problem/11052
*/

public class Main {

  public static class Card {

    public int price;
    public double pricePer;
    public int count;

    public Card(int price, int count) {
      this.price = price;
      this.count = count;
      this.pricePer = (double) price / count;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Card card = (Card) o;

      return count == card.count;
    }

    @Override
    public int hashCode() {
      return count;
    }

    @Override
    public String toString() {
      return "Card{" +
          "price=" + price +
          ", pricePer=" + pricePer +
          ", count=" + count +
          '}';
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    PriorityQueue<Card> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> -o.pricePer));

    for (int i = 0; i < p.length; i++) {
      queue.add(new Card(p[i], i + 1));
    }

    int price = 0;
    while (n != 0) {
      Card card = queue.poll();
      if (n >= card.count) {
        // 몇개 살지 결정
        int howMany = n / card.count;
        price += (card.price * howMany);
        n -= (card.count * howMany);
      }
    }

    System.out.println(price);
  }
}

