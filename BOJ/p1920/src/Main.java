import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1920 수 찾기
    url : https://www.acmicpc.net/problem/1920

    문제
        N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
        이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

    입력
        첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
        다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
        다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데,
        이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.

        5           -> 자연수 N
        4 1 5 2 3   -> N개의 정수 => A[]
        5           -> 자연수 M
        1 3 7 9 5   -> M개의 수 => 이 수가 A[] 배열안에 있는지 순차적으로 출력. 1 or 0

    출력
        M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[] find = new int[m];
        for (int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(input2[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : find) {
            boolean found = false;
            for (int i1 : a) {
                if (i == i1) {
                    found = true;
                    break;
                }
            }
            bw.write(found ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
    }
}
