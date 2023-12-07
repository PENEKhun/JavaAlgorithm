import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1436 영화감독 숌
    url : https://www.acmicpc.net/problem/1436

    종말의 수 : 6이 적어도 3개 이상 연속으로 들어가는 수
    666, 1666, 2666, 3666, 4666, 5666, 6666, 7666, 8666, 9666, 10666
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String toFind = "666";
    int[] table = new int[10000];
    int count = 0;
    int now = 666;

    while (true) {
      String sb = String.valueOf(now);
      if (sb.contains(toFind)) {
        table[count] = now;
        count++;
      }

      if (count >= n) {
        break;
      }

      now++;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(table[n - 1] + "\n");
    bw.flush();
    
    bw.close();
    br.close();
  }
}
