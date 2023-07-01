import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 10872 번- 팩토리얼
    url : https://www.acmicpc.net/problem/10872
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      System.out.println(factorial(n));
  }

  public static int factorial(int n){
    int result = 1;

    if (n == 0)
      return 1;

    while(n>0){
      result *= n--;
    }

    return result;
  }
}
