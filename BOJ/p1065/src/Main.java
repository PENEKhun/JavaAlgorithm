import java.util.Arrays;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1065 한수
    url : https://www.acmicpc.net/problem/1065

    문제
        어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
        등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

    출력
        첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
*/

public class Main {

    public static boolean isSequence(int number){
        String str = String.valueOf(number);
        char[] sets = str.toCharArray();
        int[] diff = new int[sets.length - 1];
        for (int i = 0; i < sets.length - 1; i++) {
            diff[i] = sets[i] - sets[i+1];
        }

        return Arrays.stream(diff).distinct().count() == 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cnt = 0;

        // 자릿수가 2자리 까지는 한수라고 치자. (1~99)
        if (n >= 99){
            cnt += 99;
        } else {
            cnt += n;
        }

        for (int i = 100; i <= n; i++) {
            if (isSequence(i)) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
