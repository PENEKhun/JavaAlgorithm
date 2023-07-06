import java.math.BigInteger;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #15964 이상한 기호
    url : https://www.acmicpc.net/problem/15964
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      // A@B = (A+B)*(A-B)
      BigInteger A = s.nextBigInteger();
      BigInteger B = s.nextBigInteger();
      BigInteger result = A.add(B).multiply(A.subtract(B));
      System.out.println(result);
  }
}
