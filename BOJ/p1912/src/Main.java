import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1912 연속합
    url : https://www.acmicpc.net/problem/1912

    문제
        n개의 정수로 이루어진 임의의 수열이 주어진다.
        우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
        단, 수는 한 개 이상 선택해야 한다.
        예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
        여기서 정답은 12+21인 33이 정답이 된다.

    입력
        첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

    출력
        첫째 줄에 답을 출력한다.


    MEMO


*/

public class Main {

    static Integer[] dp;
    static Integer max = -100000;
    static int[] arr;

    public static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(arr[n], arr[n] + recur(n + 1));
            max = Math.max(max, dp[n]);
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new Integer[n];
        dp[n-1] = arr[n-1];
        max = dp[n-1];

        recur(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
