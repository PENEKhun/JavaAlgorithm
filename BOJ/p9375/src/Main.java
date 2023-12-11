import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #9375 패션왕 신해빈
    url : https://www.acmicpc.net/problem/9375

    해빈아 너 패셔니스타구나...
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 0; t < testCase; t++) {
      int howManyHave = Integer.parseInt(br.readLine());
      Map<String, Integer> typeCount = new HashMap<>();
      for (int i = 0; i < howManyHave; i++) {
        String type = br.readLine().split(" ")[1];
        typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
      }

      int result = howManyHave;
      // 2가지 종류 이상일때
      if (typeCount.size() > 1) {
        // 각 조합들을 계산해서 더해야함...
        int temp = 1;
        for (int value : typeCount.values()) {
          temp *= (value + 1);
        }
        result = temp - 1;
      }

      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
  }
}
