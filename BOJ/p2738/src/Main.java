import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2738 행렬 덧셈
    url : https://www.acmicpc.net/problem/2738


입력:
    첫째 줄에 행렬의 크기 N 과 M이 주어진다.
    둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
    이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다.
    N과 M은 100보다 작거나 같고,
    행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력:
    첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
*/

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt(), m = s.nextInt();
      int[][] firstMartix = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int i1 = 0; i1 < m; i1++) {
          firstMartix[i][i1] = s.nextInt();
        }
      }

      int[][] secondMartix = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int i1 = 0; i1 < m; i1++) {
          secondMartix[i][i1] = s.nextInt();
        }
      }

      for (int i = 0; i < n; i++) {
        for (int i1 = 0; i1 < m; i1++) {
          System.out.print(
              firstMartix[i][i1] + secondMartix[i][i1] + " "
          );
        }
        if (i != n-1)
          System.out.println();
      }
  }
}
