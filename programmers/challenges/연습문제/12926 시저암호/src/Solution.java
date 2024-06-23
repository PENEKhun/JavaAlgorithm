public class Solution {

  public String solution(String s, int n) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        sb.append(' ');
        continue;
      }

      char newChar = (char) (c + (char) n);
      if ('a' <= c && c <= 'z') {
        if (newChar > 'z') {
          newChar = (char) ('a' + (newChar) - 'z' - 1);
        }
      } else {
        if (newChar > 'Z') {
          newChar = (char) ('A' + newChar - 'Z' - 1);
        }
      }
      sb.append(newChar);
    }

    return String.valueOf(sb);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

  }
}