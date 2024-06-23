import java.util.*;

class Solution {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    HashMap<String, Integer> score = new HashMap<>();
    for (int i=0; i < name.length; i++) {
      score.put(name[i], yearning[i]);
    }

    int[] answer = new int[photo.length];
    for (int i=0; i < photo.length; i++) {
      for (String item : photo[i]) {
        answer[i] += score.getOrDefault(item, 0);
      }
    }
    return answer;
  }
}