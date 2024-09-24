import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
  BAEKJOON 1967 트리의 지름
  https://www.acmicpc.net/problem/1967
*/

public class Main {
  static class Tree {
    int number;
    int weight;

    public Tree(int number, int weight) {
      this.number = number;
      this.weight = weight;
    }
  }

  static ArrayList<Tree>[] trees;
  static int result;

  public static int dfs(int current) {
    if (trees[current].isEmpty()) {
      return 0;
    }

    ArrayList<Integer> max = new ArrayList<>();
    for (Tree nextTree : trees[current]) {
      max.add(dfs(nextTree.number) + nextTree.weight);
    }
    max.sort(Comparator.comparingInt(o -> o));

    int max1 = 0;
    int max2 = 0;
    if (!max.isEmpty()) {
      max1 = max.get(max.size() - 1);
    }

    if (max.size() >= 2) {
      max2 = max.get(max.size() - 2);
    }

    result = Math.max(result, max1 + max2);
    return Math.max(max1, max2);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    trees = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      trees[i] = new ArrayList<>();
    }

    for (int i = 1; i < n; i++) {
      int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      trees[inputs[0]].add(new Tree(inputs[1], inputs[2]));
    }

    dfs(1);
    System.out.println(result);
  }
}
