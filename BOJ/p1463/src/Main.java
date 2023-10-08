import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1463 1로 만들기
    url : https://www.acmicpc.net/problem/1463
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[10000000];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= x; i++) {
            Integer[] solutions = new Integer[3];
            solutions[0] = (i % 3 == 0 ? dp[i/3] : 10000000);
            solutions[1] = (i % 2 == 0 ? dp[i/2] : 10000000);
            solutions[2] = dp[i-1];

            dp[i] = Arrays.stream(solutions).min(Integer::compareTo).get() + 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dp[x] + "\n");
        bw.flush();
        bw.close();
    }
}
