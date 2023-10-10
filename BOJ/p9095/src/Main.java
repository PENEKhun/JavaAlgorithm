import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #9095 1, 2, 3 더하기
    url : https://www.acmicpc.net/problem/9095
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        
        int testCase = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            bw.write(dp[input] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
