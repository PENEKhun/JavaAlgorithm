import java.math.BigInteger;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1676 팩토리얼 0의 개수
    url : https://www.acmicpc.net/problem/1676

    문제
        N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

    출력
        첫째 줄에 구한 0의 개수를 출력한다.

        (10 -> 2)
        (3 -> 0)
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cnt = 0;

        BigInteger factorial = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String str = factorial.toString();
        char[] arr = str.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (String.valueOf(arr[i]).equals("0")) {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
