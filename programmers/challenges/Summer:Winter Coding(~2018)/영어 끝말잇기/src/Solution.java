import java.util.*;

public class Solution {
  public int[] solution(int n, String[] words) {
    int[] answer = new int[] {0, 0};
    HashSet<String> used = new HashSet<>();
    Character lastChar = null;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      char startChar = word.charAt(0);
      if (used.contains(word) || (lastChar != null && lastChar != startChar)) {
        answer[0] = i % n + 1;
        answer[1] = (i / n) + 1;
        break;
      } else {
        used.add(word);
        lastChar = word.charAt(word.length() - 1);
      }
    }
    return answer;
  }

  public static void main(String[] args){
    Solution solution = new Solution();
    
  }
}