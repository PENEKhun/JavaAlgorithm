import java.util.Arrays;
import java.util.HashMap;

class Solution {
  static HashMap<Integer, int[]> nodeDegrees = new HashMap<>();

  public int[] solution(int[][] edges) {
    for (int[] edge : edges) {
      int src = edge[0];
      int dest = edge[1];

      nodeDegrees.putIfAbsent(src, new int[2]);
      nodeDegrees.putIfAbsent(dest, new int[2]);

      nodeDegrees.get(src)[0]++; // out-degree 증가
      nodeDegrees.get(dest)[1]++; // in-degree 증가
    }

    int mainPoint = -1;
    int totalGraphs = 0;
    int donutCount = 0;
    int stickCount = 0;
    int eightCount = 0;

    for (int node : nodeDegrees.keySet()) {
      int outDegree = nodeDegrees.get(node)[0];
      int inDegree = nodeDegrees.get(node)[1];

      if (outDegree >= 2 && inDegree == 0) {
        mainPoint = node;
        totalGraphs = outDegree;
      } else if (outDegree == 0 && inDegree > 0) {
        stickCount++;
      } else if (outDegree >= 2 && inDegree >= 2) {
        eightCount++;
      }
    }

    donutCount = totalGraphs - stickCount - eightCount;

    return new int[] {mainPoint, donutCount, stickCount, eightCount};
  }

  public static void main(String[] args) {
    Solution Sol = new Solution();
    System.out.println(
        Arrays.toString(Sol.solution(
            new int[][] {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
                {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}))
    );
  }
}
