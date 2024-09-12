import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
  BAEKJOON 5639 이진 검색 트리
  https://www.acmicpc.net/problem/5639
*/

public class Main {
  public static StringBuilder result = new StringBuilder();

  public static class Node {
    int num;
    Node left;
    Node right;

    public Node(int num) {
      this.num = num;
    }
  }

  public static Node makeTree(List<Integer> nodes) {
    if (nodes.isEmpty()) {
      return null;
    }

    Node parentNode = new Node(nodes.get(0));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int i = 1; i < nodes.size(); i++) {
      if (parentNode.num < nodes.get(i)) {
        right.add(nodes.get(i));
      } else {
        left.add(nodes.get(i));
      }
    }

    parentNode.left = makeTree(left);
    parentNode.right = makeTree(right);
    return parentNode;
  }

  public static void makeResult(Node node) {
    if (node == null) {
      return;
    }

    makeResult(node.left);
    makeResult(node.right);
    result.append(node.num).append("\n");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> numbers = new ArrayList<>();
    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      numbers.add(Integer.valueOf(line));
    }

    Node node = makeTree(numbers);
    makeResult(node);
    System.out.println(result);
  }
}
