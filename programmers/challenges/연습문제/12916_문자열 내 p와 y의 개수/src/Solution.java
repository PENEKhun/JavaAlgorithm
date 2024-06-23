public class Solution {

  boolean solution(String s) {
    int pLen = s.length() - s.replaceAll("P|p", "").length();
    int yLen = s.length() - s.replaceAll("Y|y", "").length();
    System.out.println(pLen);
    System.out.println(yLen);
    return pLen == yLen;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        solution.solution("Pyy")
    );
  }
}