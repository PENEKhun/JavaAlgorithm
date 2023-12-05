import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1003 피보나치 함수
    url : https://www.acmicpc.net/problem/1003
*/

public class Main {


    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws IOException {
        memo[0][0] = 1;
        memo[0][1] = 0;

        memo[1][0] = 0;
        memo[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            bw.write(memo[input][0] + " " + memo[input][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
