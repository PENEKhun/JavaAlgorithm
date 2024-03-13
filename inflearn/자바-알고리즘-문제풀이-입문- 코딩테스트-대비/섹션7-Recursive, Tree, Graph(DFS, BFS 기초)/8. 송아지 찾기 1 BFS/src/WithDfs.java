import java.util.Scanner;

public class WithDfs {

  static int targetPos;
  static int result = Integer.MAX_VALUE;
  static int[] d = {1, -1, 5};
  static int[] visited;

  static void dfs(int myPos, int cnt) {
    if (visited[myPos] != 0 && visited[myPos] < cnt) {
      return;
    }

    visited[myPos] = cnt;
    if (myPos == targetPos) {
      result = Math.min(result, cnt);
      return;
    }

    for (int i : d) {
      if (myPos + i > targetPos + 6) {
        continue;
      }

      if (myPos + i >= 0) {
        dfs(myPos + i, cnt + 1);
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int myPos = s.nextInt();
    targetPos = s.nextInt();
    visited = new int[targetPos + 7];

    dfs(myPos, 0);
    System.out.println(result);
  }
}