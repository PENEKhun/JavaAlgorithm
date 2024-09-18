import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
  BAEKJOON 2504 괄호의 값
  https://www.acmicpc.net/problem/2504
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();

    Stack<Character> braketStack = new Stack<>();
    Stack<Integer> resultStack = new Stack<>();
    for (char c : input) {
      if (c == '(' || c == '[') {
        braketStack.push(c);
        resultStack.push(-1);
      } else if (c == ')' || c == ']') {
        int temp = 0;
        // -1 괄호까지 덧셈
        while (!resultStack.isEmpty() && resultStack.peek() != -1) {
          temp += resultStack.pop();
        }

        // -1 괄호가 무조건 있어야함.
        if (resultStack.isEmpty()) {
          System.out.println(0);
          return;
        }

        resultStack.pop();
        char openBracket = braketStack.pop();

        if ((c == ')' && openBracket != '(') || (c == ']' && openBracket != '[')) {
          System.out.println(0);
          return;
        }

        if (c == ')') {
          resultStack.push(temp == 0 ? 2 : 2 * temp);
        } else {
          resultStack.push(temp == 0 ? 3 : 3 * temp);
        }
      }
    }

    int result = 0;
    while (!resultStack.isEmpty()) {
      int val = resultStack.pop();
      // -1 괄호가 있으면 안됨.
      if (val == -1) {
        System.out.println(0);
        return;
      }

      result += val;
    }

    System.out.println(result);
  }
}
