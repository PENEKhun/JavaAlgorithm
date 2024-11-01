import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
  BAEKJOON 9935 문자열 폭발
  https://www.acmicpc.net/problem/9935
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String regex = br.readLine();

    Stack<Character> stack = new Stack<>();

    for (int i=0; i<input.length(); i++) {
      char c = input.charAt(i);
      stack.push(c);

      if (stack.size() >= regex.length()) {
        boolean hasRegex = true;
        for (int k=0; k<regex.length(); k++) {
          if (stack.get(stack.size() - regex.length() + k) != regex.charAt(k)) {
            hasRegex = false;
            break;
          }
        }

        if (hasRegex) {
          for (int k=0; k<regex.length(); k++) {
            stack.pop();
          }
        }
      }
    }


    StringBuilder result = new StringBuilder();
    for (char c : stack) {
      result.append(c);
    }

    System.out.println(result.isEmpty() ? "FRULA" : result);
  }
}
