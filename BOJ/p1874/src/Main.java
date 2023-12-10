import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1874 스택 수열
    url : https://www.acmicpc.net/problem/1874
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    int[] numSeq = new int[n];
    for (int i = 0; i < n; i++) {
      numSeq[i] = Integer.parseInt(br.readLine());
    }

    StringBuilder result = new StringBuilder();
    int num = 1;
    int seqIdx = 0;
    while (true) {
      if (!stack.isEmpty() && stack.peek() == numSeq[seqIdx]) {
        // pop하는 경우
        stack.pop();
        seqIdx++;
        result.append("-\n");
      } else if (seqIdx == n) {
        // 성공 탈출
        break;
      } else if (!stack.contains(numSeq[seqIdx])) {
        // push 하는 경우
        stack.push(num++);
        result.append("+\n");
      } else {
        // 실패 경우
        result = new StringBuilder("NO\n");
        break;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
