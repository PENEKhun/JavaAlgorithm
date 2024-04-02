import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/*
  BAEKJOON 1991 트리 순회
  https://www.acmicpc.net/problem/1991
*/

public class Main {

  public static void first(Tree tree) {
    if (tree.name != null) {
      System.out.printf(tree.name);
    }

    if (tree.left != null) {
      first(tree.left);
    }

    if (tree.right != null) {
      first(tree.right);
    }
  }

  public static void second(Tree tree) {
    if (tree.left != null) {
      second(tree.left);
    }

    if (tree.name != null) {
      System.out.printf(tree.name);
    }

    if (tree.right != null) {
      second(tree.right);
    }
  }

  public static void third(Tree tree) {
    if (tree.left != null) {
      third(tree.left);
    }

    if (tree.right != null) {
      third(tree.right);
    }

    if (tree.name != null) {
      System.out.printf(tree.name);
    }

  }

  static class Tree {

    public String name;
    public Tree left;
    public Tree right;

    public static void addNode(Tree tree, String target, String left, String right) {
      if (tree.name.equals(target)) {
        if (!Objects.equals(left, ".")) {
          tree.left = new Tree(left);
        }
        if (!Objects.equals(right, ".")) {
          tree.right = new Tree(right);
        }

        return;
      }

      if (tree.right != null) {
        addNode(tree.right, target, left, right);
      }

      if (tree.left != null) {
        addNode(tree.left, target, left, right);
      }
    }

    public Tree(String name) {
      this.name = name;
    }

    public Tree() {
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Tree tree = new Tree("A");

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      Tree.addNode(tree, input[0], input[1], input[2]);
    }

    first(tree);
    System.out.println();
    second(tree);
    System.out.println();
    third(tree);
    System.out.println();
  }
}