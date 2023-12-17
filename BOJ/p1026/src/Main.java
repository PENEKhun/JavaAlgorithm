import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1026 보물
    url : https://www.acmicpc.net/problem/1026
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    a = Arrays.stream(a).sorted().toArray();
    b = Arrays.stream(b).sorted().toArray();

    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      int indexB = b.length - i - 1;
      sum += a[i] * b[indexB];
    }
    System.out.println(sum);
  }
}
