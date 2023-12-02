/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11286 절댓값 힙
    url : https://www.acmicpc.net/problem/11286
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> arr = new PriorityQueue<>((o1, o2) -> {
      if (Math.abs(o1) > Math.abs(o2)) {
        return Math.abs(o1) - Math.abs(o2);
      } else if (Math.abs(o1) == Math.abs(o2)) {
        return o1 - o2;
      } else {
        return -1;
      }
    });

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input != 0) {
        arr.offer(input);
        continue;
      }

      if (arr.isEmpty()) {
        bw.write("0\n");
      } else {
        bw.write(arr.poll() + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
