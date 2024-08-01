import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1049 기타줄
  https://www.acmicpc.net/problem/1049
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int n = Integer.parseInt(NM[0]);
    int m = Integer.parseInt(NM[1]);
    int packagePriceMin = Integer.MAX_VALUE;
    int singleMin = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");
      int packagePrice = Integer.parseInt(input[0]);
      int singlePrice = Integer.parseInt(input[1]);
      packagePriceMin = Math.min(packagePrice, packagePriceMin);
      singleMin = Math.min(singlePrice, singleMin);
    }

    int price = 0;
    int remain = n;
    if (packagePriceMin < singleMin * 6) {
      price += (remain / 6) * packagePriceMin;
      remain %= 6;
      if (remain > 0) {
        price += Math.min(singleMin * remain, packagePriceMin);
      }
    } else {
      // 패키지 가격이 더 비싸면
      price += remain * singleMin;
    }

    System.out.println(price);
  }
}
