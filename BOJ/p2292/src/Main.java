import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2292 벌집
    url : https://www.acmicpc.net/problem/2292
*/

public class Main {

    public static int solution(int n) {
        if (n == 1)
            return 1;

        if (n <= 7)
            return 2;

        int result = 3;
        int startAt = 8;
        int inc = 11;

        while (true) {
            if (startAt + inc >= n) {
                return result;
            }

            startAt = startAt + inc + 1;
            result = result + 1;
            inc = inc + 6;
        }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        /*
        1
        2 ~ 7  -> 5
        8 ~ 19  -> 11
        20 ~ 37 -> 17
        38 ~ 61 -> 23


        1 5 11 17 23
         4  6  6  6
         */

        System.out.println(solution(n));
    }
}
