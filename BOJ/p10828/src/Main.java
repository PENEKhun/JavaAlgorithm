import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10828 스택
    url : https://www.acmicpc.net/problem/10828
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < lines; i++) {
            String line = br.readLine();
            if (line.startsWith("push")) {
                // push X: 정수 X를 스택에 넣는 연산이다.
                int element = Integer.parseInt(line.split(" ")[1]);
                stack.push(element);

            } else if (line.startsWith("pop")) {
                // pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
                
            } else if (line.startsWith("size")) {
                // size: 스택에 들어있는 정수의 개수를 출력한다.
                bw.write(stack.size() + "\n");

            } else if (line.startsWith("empty")) {
                // empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
                if (stack.isEmpty()){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }

                
            } else if (line.startsWith("top")) {
                // top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }

        }

        bw.flush();
        bw.close();
    }
}
