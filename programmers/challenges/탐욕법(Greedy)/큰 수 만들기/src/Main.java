import java.util.Arrays;
import java.util.Stack;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    /*
    "1924"	2	"94"
    "1231234"	3	"3234"
    "4177252841"	4	"775841"
     */
//    System.out.println(solution.solution("1924", 2));
//    System.out.println(solution.solution("1231234", 3));
//    System.out.println(solution.solution("4177252841", 4));
//    System.out.println(solution.solution("333222111", 5));
    System.out.println(solution.solution("6547", 3));
  }

  public String solution(String number, int k) {
    int[] numList = Arrays.stream(number.split("")).mapToInt(Integer::parseInt)
        .toArray();
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    for (int i=0; i<number.length(); i++) {
      int num = numList[i];
      while (!stack.isEmpty() && stack.peek() < num && k-- > 0) {
        stack.pop();
      }

      stack.push(num);
    }

    int size = Math.min(stack.size(), number.length() - k);
    for (int i=0; i< size; i++) {
      sb.append(stack.get(i));
    }

    return sb.toString();
  }
}