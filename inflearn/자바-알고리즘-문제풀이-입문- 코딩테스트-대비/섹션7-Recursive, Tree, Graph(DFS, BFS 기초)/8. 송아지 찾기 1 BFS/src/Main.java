import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  static int targetPos;
  static int[] d = {1, -1, 5};
  static int[] visited;

  static int bfs(int myPos) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(myPos);
    int result = 0;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i : d) {
        int dPos = now + i;
        if (dPos < 0) {
          continue;
        }

        if (visited[dPos] != 0) {
          continue;
        }

        visited[dPos] = visited[now] + 1;
        if (dPos == targetPos) {
          result = visited[dPos];
          break;
        }

        queue.offer(now + i);
      }

      if (result != 0) {
        break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int myPos = s.nextInt();
    targetPos = s.nextInt();
    visited = new int[10_001];
    System.out.println(bfs(myPos));
  }
}