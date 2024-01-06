import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/*
      BAEKJOON 1927 최소 힙
      https://www.acmicpc.net/problem/1927
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 연산의 갯수
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    PriorityQueue<Integer> nums = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0){
        if (nums.isEmpty()) {
          bw.write("0\n");
        } else {
          bw.write(nums.poll() + "\n");
        }
        continue;
      }

      nums.add(input);
    }

    bw.flush();
  }
}
