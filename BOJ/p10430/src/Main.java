import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10430 나머지
    url : https://www.acmicpc.net/problem/10430
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        // 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C)) %C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C)) %C);
  }
}
