import java.util.*;

class Solution {
  public int[] solution(int[] answers) {
    int[] correct = {0, 0, 0};
    int[] one = {1, 2, 3, 4, 5};
    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int ansLen = answers.length;
    int max = 0;
    for (int i=0; i<ansLen; i++) {
      int nowAns = answers[i];
      if (nowAns == one[i % one.length]) {
        correct[0]++;
      }

      if (nowAns == two[i % two.length]) {
        correct[1]++;
      }

      if (nowAns == three[i % three.length]) {
        correct[2]++;
      }

      max = Math.max(max, correct[0]);
      max = Math.max(max, correct[1]);
      max = Math.max(max, correct[2]);
    }

    List<Integer> resultTemp = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      if (correct[i] == max) {
        resultTemp.add(i+1);
      }
    }

    int[] result = new int[resultTemp.size()];
    for (int i=0; i<resultTemp.size(); i++) {
      result[i] = resultTemp.get(i);
    }

    return result;
  }
}
