import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #24416 알고리즘 수업 - 피보나치 수 1
    url : https://www.acmicpc.net/problem/24416

    오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
    오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
    피보나치 수 재귀호출 의사 코드는 다음과 같다.

    fib(n) {
        if (n = 1 or n = 2)
        then return 1;  # 코드1
        else return (fib(n - 1) + fib(n - 2));
    }
    피보나치 수 동적 프로그래밍 의사 코드는 다음과 같다.

    fibonacci(n) {
        f[1] <- f[2] <- 1;
        for i <- 3 to n
            f[i] <- f[i - 1] + f[i - 2];  # 코드2
        return f[n];
    }

    위 두 코드의 실행 횟수를 나열하라.

    보니깐 fib(n) 실행 횟수가 1, 1, 2, 3, 5, 10, 15 이거네....
*/

public class Main {
    public static int fibCnt(int n){
        if (n == 1 || n == 2)
            return 1;

        return fibCnt(n-1) + fibCnt(n-2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibCnt(n) + " " + (n-2));
    }
}
