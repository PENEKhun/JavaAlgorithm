import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1009 분산처리
    url : https://www.acmicpc.net/problem/1009
*/

public class Main {

  public static int mod(int a, int b) {
    if (b == 0) {
      return 1;
    }

    int temp = mod(a, b / 2);
    int result = (temp * temp) % 10;

    if (b % 2 == 0) {
      return result;
    } else {
      return (result * a) % 10;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder toPrint = new StringBuilder();
    int testCase = Integer.parseInt(br.readLine());
    for (int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      int result = mod(a, b) % 10;

      toPrint.append(((result == 0) ? "10" : result) + "\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(toPrint.toString());

    bw.close();
    br.close();
  }
}
