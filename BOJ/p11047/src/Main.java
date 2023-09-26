import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11047 동전 0
    url : https://www.acmicpc.net/problem/11047

    문제
        준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
        동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

    입력
        첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
        둘째 줄부터 N개의 줄에 동전의 가치 A_{i}가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

    출력
        첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

    10 4200 -> N과 K
    1
    5
    10
    50
    100
    500
    1000
    5000
    10000
    50000
*/

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int k = s.nextInt();
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = s.nextInt();
    }

    int tempPrice = k;
    int cnt = 0;
    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] > tempPrice) {
        continue;
      }

      if (a[i] == tempPrice) {
        cnt++;
        break;
      }

      if (a[i] < tempPrice) {
        cnt += tempPrice / a[i];
        tempPrice -= (tempPrice / a[i]) * a[i];
        if (tempPrice % a[i] == 0) {
          break;
        }
      }
    }

    System.out.println(cnt);
  }
}
