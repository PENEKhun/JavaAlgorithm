import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11723 집합
    url : https://www.acmicpc.net/problem/11723
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        HashSet<Short> arr = new HashSet<>();
        HashSet<Short> all = new HashSet<>();
        for (short i = 1; i <= 20; i++) {
            all.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String action = inputs[0];
            Short arg = null;
            if (inputs.length > 1)
             arg = Short.valueOf(inputs[1]);

            switch (action) {
                case "add" -> arr.add(arg);
                case "remove" -> arr.remove(arg);
                case "check" -> bw.write((arr.contains(arg) ? "1\n" : "0\n"));
                case "toggle" -> {
                    if (arr.contains(arg)) {
                        arr.remove(arg);
                    } else {
                        arr.add(arg);
                    }
                }
                case "all" -> arr = (HashSet<Short>) all.clone();
                case "empty" -> arr.clear();
                default -> {
                    // do nothing
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
