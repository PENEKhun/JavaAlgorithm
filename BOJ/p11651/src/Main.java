import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11651 좌표 정렬하기 2
    url : https://www.acmicpc.net/problem/11651
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] points = new int[n][2];

    for (int i = 0; i < n; i++) {
      String[] inputs = br.readLine().split(" ");
      int x = Integer.parseInt(inputs[0]);
      int y = Integer.parseInt(inputs[1]);

      points[i] = new int[]{x, y};
    }

    Comparator<? super int[]> CustomSort = (Comparator<int[]>) (o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      } else {
        return o1[1] - o2[1];
      }
    };

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder result = new StringBuilder();
    Arrays.stream(points).sorted(CustomSort)
        .forEach(
            data -> result.append(data[0]).append(" ").append(data[1]).append("\n")
        );

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
