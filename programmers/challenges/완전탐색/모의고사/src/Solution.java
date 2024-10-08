import java.util.*;

class Solution {
  public int[] solution(int[] answers) {
    int[] correct = new int[] {0, 0, 0};
    int ansLen = answers.length;
    int one = 1;
    int twoAns = 1;
    int twoIdx = 0;
    int threeIdx = 0;
    int threeAns = 3;
    int max = 0;
    for (int i=0; i<ansLen; i++) {
      int nowAns = answers[i];
      if (nowAns == one) {
        correct[0]++;
      }

      one++;
      if (one == 6) {
        one = 1;
      }

      if (twoIdx % 2 == 0) {
        if (nowAns == 2) {
          correct[1]++;
        }
      } else {
        if (nowAns == twoAns) {
          correct[1]++;
        }
        twoAns++;
        if (twoAns == 2) {
          twoAns++;
        }
        if (twoAns == 6) {
          twoAns = 1;
        }
      }
      twoIdx++;

      // 33, 11, 22, 44, 55
      if (threeAns == nowAns) {
        correct[2]++;
      }
      threeIdx++;
      if (threeIdx == 2) {
        if (threeAns == 3) {
          threeAns = 1;
        } else if (threeAns == 1) {
          threeAns = 2;
        } else if (threeAns == 2) {
          threeAns = 4;
        } else if (threeAns == 4) {
          threeAns = 5;
        } else if (threeAns == 5) {
          threeAns = 3;
        }
        threeIdx = 0;
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
