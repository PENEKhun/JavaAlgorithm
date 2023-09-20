import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1764 듣보잡
    url : https://www.acmicpc.net/problem/1764
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 듣도 못한 사람의 수
        int m = Integer.parseInt(s[1]); // 보도 못한 사람의 수

        HashSet<String> neverSeen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            neverSeen.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (neverSeen.contains(name)){
                result.add(name);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.size() + "");
        bw.newLine();

        result.stream().sorted()
            .forEach(
            name -> {
                try {
                    bw.write(name);
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        );

        bw.flush();
        bw.close();
    }
}
