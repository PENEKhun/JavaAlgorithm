import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10845 큐
    url : https://www.acmicpc.net/problem/10845
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push ")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                queue.add(num);
            } else if (cmd.equals("pop")) {
                Integer num = queue.poll();
                if (num == null)
                    bw.write("-1\n");
                else bw.write(num + "\n");
            } else if (cmd.equals("size")) {
                bw.write(queue.size() + "\n");

            } else if (cmd.equals("empty")) {
                bw.write(queue.isEmpty() ? "1\n" : "0\n");

            } else if (cmd.equals("front")) {
                Integer num = queue.peek();
                if (num == null)
                    bw.write("-1\n");
                else bw.write(num + "\n");
            } else if (cmd.equals("back")) {
                int size = queue.size();
                if (size == 0)
                    bw.write("-1\n");
                else bw.write(queue.toArray()[size-1] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
