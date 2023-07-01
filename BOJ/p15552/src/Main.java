/*
    성훈ㅇㅏ.... 화이팅하자 ....
    BAEKJOON - 15552 번- 빠른 A+B
    url : https://www.acmicpc.net/problem/15552
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++){
        String line = br.readLine();
        int a = Integer.parseInt(line.split(" ")[0]);
        int b = Integer.parseInt(line.split(" ")[1]);
        String result = String.valueOf(a + b);
        bw.write(result);
        bw.newLine();
      }
      bw.flush();

      bw.close();
      br.close();
  }
}
