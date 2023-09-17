import java.util.Arrays;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #4153 직각삼각형
    url : https://www.acmicpc.net/problem/4153
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();

            if (a == 0 && b == 0 && c == 0){
                break;
            }

            int[] res = {a, b, c};
            res = Arrays.stream(res).sorted().toArray();

            if (res[2] * res[2] == res[1] * res[1] + res[0] * res[0]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
