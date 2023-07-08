import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2480 주사위 세개
    url : https://www.acmicpc.net/problem/2480
*/

public class Main {
    public static void main(String[] args) {
        /*같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.*/

        Scanner s = new Scanner(System.in);
        int[] dice = new int[3];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = s.nextInt();
        }

        if (dice[0] == dice[1] && dice[1] == dice[2]){
            System.out.println(dice[0] * 1000 + 10000);
        } else if (dice[0] == dice[1] || dice[1] == dice[2]) {
            System.out.println(dice[1] * 100 + 1000);
        } else if (dice[0] == dice[2]) {
            System.out.println(dice[0] * 100 + 1000);
        } else {
            System.out.println(Arrays.stream(dice).max().getAsInt() * 100);
        }
    }
}
