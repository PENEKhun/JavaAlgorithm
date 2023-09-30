import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #9184 신나는 함수 실행
    url : https://www.acmicpc.net/problem/9184

    문제
        재귀 호출만 생각하면 신이 난다! 아닌가요?
        다음과 같은 재귀함수 w(a, b, c)가 있다.

        if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
            1

        if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
            w(20, 20, 20)

        if a < b and b < c, then w(a, b, c) returns:
            w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

        otherwise it returns:
            w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)

        a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
*/

public class Main {
    // 주어진 함수
    static int[][][] memo = new int[21][21][21];

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (memo[a][b][c] != 0)
            return memo[a][b][c];

        if (a < b && b < c){
            return memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1)
            - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            String[] split = str.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);

            if (a == -1 && b == -1 && c == -1){
                break;
            }

            bw.write("w(%s, %s, %s) = %s \n".formatted(a, b, c, w(a, b, c)));
        }

        bw.flush();
        bw.close();
    }
}
