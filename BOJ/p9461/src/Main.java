import java.math.BigInteger;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #9461 파도반 수열
    url : https://www.acmicpc.net/problem/9461
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigInteger[] dp = new BigInteger[101];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;
        dp[3] = BigInteger.ONE;
        dp[4] = BigInteger.TWO;
        dp[5] = BigInteger.TWO;

        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();

            if (dp[n] != null) {
                System.out.println(dp[n]);
            } else {
                for (int ii = 6; ii <= n; ii++) {
                    dp[ii] = dp[ii - 1].add(dp[ii - 5]);
                }
                System.out.println(dp[n]);
            }
        }
        
    }
}
