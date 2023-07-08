import java.util.Scanner;
import java.util.stream.Stream;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #8393 합
    url : https://www.acmicpc.net/problem/8393
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 0;
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
