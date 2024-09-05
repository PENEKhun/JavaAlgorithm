import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
  BAEKJOON 17413 단어 뒤집기 2
  https://www.acmicpc.net/problem/17413
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Stack<Character> stack = new Stack<>();
    char[] input = br.readLine().toCharArray();
    boolean tagMode = false;
    for (int i = 0; i < input.length; i++) {
      // <나 스페이스 만나면 풀기
      if (input[i] == '<') {
        tagMode = true;
        while (!stack.isEmpty()) {
          bw.write(stack.pop());
        }
        bw.write(input[i]);
      } else if (!tagMode && input[i] == ' ') {
        while (!stack.isEmpty()) {
          bw.write(stack.pop());
        }
        bw.write(input[i]);
      } else if (tagMode) {
        bw.write(input[i]);
        if (input[i] == '>') {
          tagMode = false;
        }
      } else {
        stack.add(input[i]);
      }

      if (i == input.length - 1) {
        while (!stack.isEmpty()) {
          bw.write(stack.pop());
        }
      }
    }
    bw.flush();
  }
}
