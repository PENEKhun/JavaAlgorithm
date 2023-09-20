import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1748 수 이어 쓰기 1
    url : https://www.acmicpc.net/problem/1748
*/
public class Main {
    private static int getLen(int number){
        if (number <= 9)
            return 1;
        if (number <= 99)
            return 2;
        if (number <= 999)
            return 3;
        if (number <= 9_999)
            return 4;
        if (number <= 99_999)
            return 5;
        if (number <= 999_999)
            return 6;
        if (number <= 9_999_999)
            return 7;
        if (number <= 99_999_999)
            return 8;
        if (number == 100_000_000)
            return 9;

        throw new IllegalArgumentException("??");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += getLen(i);
        }

        System.out.println(result);
    }



    /*
    타임 아웃

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        System.out.println(sb.length());
    }
     */
}
