import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
  BAEKJOON 1918 후위 표기식
  https://www.acmicpc.net/problem/1918
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    char[] arr = input.toCharArray();
    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();

    for (char c : arr) {
      switch (c) {
        case '+', '-', '*', '/':
          while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
            result.append(stack.pop());
          }
          stack.add(c);
          break;
        case '(':
          stack.add(c);
          break;
        case ')':
          while (!stack.isEmpty() && stack.peek() != '(') {
            result.append(stack.pop());
          }
          stack.pop();
          break;
        default:
          result.append(c);
      }
    }

    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }

    System.out.println(result);
  }

  public static int priority(char operator) {

    if (operator == '(' || operator == ')') {
      return 0;
    } else if (operator == '+' || operator == '-') {
      return 1;
    } else if (operator == '*' || operator == '/') {
      return 2;
    }
    return -1;
  }
}