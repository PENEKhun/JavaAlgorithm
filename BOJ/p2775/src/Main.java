import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2775 부녀회장이 될테야
    url : https://www.acmicpc.net/problem/2775
*/

public class Main {

    static Integer[][] dp;
    public static int solution(int floor, int ho){
        if (floor == 0)
            return ho;

        if (ho < 0)
            return 0;

        if (dp[floor][ho] != null)
            return dp[floor][ho];

        return dp[floor][ho] = solution(floor-1, ho) + solution(floor, ho-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
            이 아파트에 거주를 하려면 조건이 있는데,
            “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

            아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
            주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
         */

        int testCase = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < testCase; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            dp = new Integer[k + 1][n + 1];
            bw.write(solution(k, n) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
