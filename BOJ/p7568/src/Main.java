import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #7568 덩치
    url : https://www.acmicpc.net/problem/7568
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] peoples = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int weight = Integer.parseInt(input[0]);
      int height = Integer.parseInt(input[1]);

      peoples[i] = new int[]{weight, height};
    }

    for (int i = 0; i < peoples.length; i++) {
      int[] item = peoples[i];
      int howManyGreaterThan = 1;
      for (int j = 0; j < peoples.length; j++) {
        if (i != j) {
          int[] target = peoples[j];
          if (item[0] < target[0] && item[1] < target[1]) {
            howManyGreaterThan++;
          }
        }
      }

      bw.write(howManyGreaterThan + " ");
    }

    bw.flush();
    bw.close();
  }
}
