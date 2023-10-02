import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11050 이항 계수 1
    url : https://www.acmicpc.net/problem/11050
*/

public class Main {
    public static int solution(int n, int k){
        if (k < 0)
            return 0;

        if (k > n)
            return 0;

        int nFact = 1;
        for (int i = 1; i <= n; i++) {
            nFact *= i;
        }

        int kFact = 1;
        for (int i = 1; i <= k; i++) {
            kFact *= i;
        }

        int nMk = n - k;
        int nMkF = 1;
        for (int i = 1; i <= nMk; i++) {
            nMkF *= i;
        }

        return nFact / (kFact * nMkF);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        System.out.println(solution(n, k));
    }
}
