import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10866 덱
    url : https://www.acmicpc.net/problem/10866
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push_front ")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                deque.addFirst(num);

            } else if (cmd.startsWith("push_back ")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                deque.addLast(num);

            } else if (cmd.equals("pop_front")) {
                try {
                    int num = deque.removeFirst();
                    bw.write(num + "\n");
                } catch (NoSuchElementException e) {
                    bw.write("-1\n");
                }
                
            } else if (cmd.equals("pop_back")) {
                try {
                    int num = deque.removeLast();
                    bw.write(num + "\n");
                } catch (NoSuchElementException e) {
                    bw.write("-1\n");
                }


                
            } else if (cmd.equals("size")) {
                bw.write(deque.size() + "\n");
                
            } else if (cmd.equals("empty")) {
                boolean empty = deque.isEmpty();
                bw.write( (empty) ? "1\n" : "0\n");
                
            } else if (cmd.equals("front")) {
                Integer num = deque.peekFirst();
                bw.write( (num == null) ? "-1\n" : num + "\n");

            } else if (cmd.equals("back")) {
                Integer num = deque.peekLast();
                bw.write( (num == null) ? "-1\n" : num + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
