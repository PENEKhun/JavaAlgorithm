import java.math.BigInteger;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2609 최대공약수와 최소공배수
    url : https://www.acmicpc.net/problem/2609

    문제
        두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

    출력
        첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
*/

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    int n = s.nextInt();

    BigInteger mm = BigInteger.valueOf(m);
    BigInteger nn = BigInteger.valueOf(n);

    BigInteger gcd = mm.gcd(nn);
    System.out.println(gcd);
    System.out.println(mm.multiply(nn).divide(gcd));
  }
}
