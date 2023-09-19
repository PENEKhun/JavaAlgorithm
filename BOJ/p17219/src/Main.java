import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #17219 비밀번호 찾기
    url : https://www.acmicpc.net/problem/17219
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int storage = Integer.parseInt(input[0]);
        int find = Integer.parseInt(input[1]);

        HashMap<String, String> database = new HashMap<>();

        for (int i = 0; i < storage; i++) {
            String line = bf.readLine();
            String[] split = line.split( " ");
            String domain = split[0];
            String password = split[1];
            database.put(domain, password);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
        for (int i = 0; i < find; i++) {
            String toFind = bf.readLine();
            bw.write(database.get(toFind));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
