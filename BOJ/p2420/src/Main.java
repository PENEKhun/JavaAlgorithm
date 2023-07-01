
import java.math.BigInteger;
import java.util.Scanner;

/*
    BAEKJOON - 2420 번
    url : https://www.acmicpc.net/problem/2420
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      BigInteger a = s.nextBigInteger();
      BigInteger b = s.nextBigInteger();

      System.out.println(a.subtract(b).abs());
  }
}

