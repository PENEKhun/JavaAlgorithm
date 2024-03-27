import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
  BAEKJOON 13305 주유소
  https://www.acmicpc.net/problem/13305
*/

public class Main {

  public static class Road {

    public int num;

    public Integer distance;
    public int oilPricePerLitter;

    public Road(int num) {
      this.num = num;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Road[] roads = new Road[n];
    String[] distances = br.readLine().split(" ");
    // init
    for (int i = 0; i < n; i++) {
      roads[i] = new Road(i);
    }

    for (int i = 0; i < n - 1; i++) {
      roads[i].distance = Integer.valueOf(distances[i]);
    }

    String[] oilPrice = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      roads[i].oilPricePerLitter = Integer.parseInt(oilPrice[i]);
    }

    long fee = 0;
    Stack<Road> stack = new Stack<>();
    stack.add(roads[0]);

    int size = 0;
    for (int i = 1; i < n - 1; i++) {
      if (stack.peek().oilPricePerLitter > roads[i].oilPricePerLitter) {
        stack.add(roads[i]);
        size++;
      }
    }

    int distance = 0;
    for (int i = n - 2; i >= 0; i--) {

      distance += roads[i].distance;
      if (stack.get(size).num == roads[i].num) {
        Road road = stack.get(size);
        fee += (long) road.oilPricePerLitter * distance;
        distance = 0;
        stack.remove(size);
        size--;
      }
    }

    System.out.println(fee);
  }
}