import java.util.*;

public class Solution {
  boolean solution(String s) {
    char[] chars = s.toCharArray();
    int remainToClose = 0;
    Queue<Character> stack = new LinkedList<>();
    for (char aChar : chars) {
      stack.add(aChar);
    }

    while (!stack.isEmpty()) {
      char item = stack.poll();
      if (item == '(') {
        remainToClose++;
      } else {
        if (remainToClose == 0) {
          return false;
        }

        remainToClose--;
      }
    }

    return remainToClose == 0;
  }
}