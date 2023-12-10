import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.Stack;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #4949 균형잡힌 세상
    url : https://www.acmicpc.net/problem/4949
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();
    while (true) {
      String input = br.readLine();
      if (Objects.equals(input, ".")) {
        break;
      }

      Stack<String> stack = new Stack<>();
      for (int i = 0; i < input.length(); i++) {
        char point = input.charAt(i);
        if (point == '(') {
          stack.add("(");
        }

        if (point == ')') {
          if (stack.isEmpty()) {
            result.append("no\n");
            break;
          }

          if (!Objects.equals(stack.pop(), "(")) {
            result.append("no\n");
            break;
          }
        }

        if (point == '[') {
          stack.add("[");
        }

        if (point == ']') {
          if (stack.isEmpty()) {
            result.append("no\n");
            break;
          }
          
          if (!Objects.equals(stack.pop(), "[")) {
            result.append("no\n");
            break;
          }
        }

        if (i == input.length() - 1) {
          if (stack.isEmpty()) {
            result.append("yes\n");
          } else {
            result.append("no\n");
          }
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(result.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
