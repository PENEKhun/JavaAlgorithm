import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
  BAEKJOON 19941 햄버거 분배
  https://www.acmicpc.net/problem/19941
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]); // 식탁의 길이
    int K = Integer.parseInt(inputs[1]); // 햄버거를 선택할 수 있는 거리
    int ans = 0;

    Queue<Integer> burgers = new ArrayDeque<>();
    Queue<Integer> persons = new ArrayDeque<>();
    char[] map = br.readLine().toCharArray();
    for (int pos = 0; pos < map.length; pos++) {
      if (!burgers.isEmpty() && Math.abs(pos - burgers.peek()) > K) {
        burgers.poll();
      }
      if (!persons.isEmpty() && Math.abs(pos - persons.peek()) > K) {
        persons.poll();
      }

      if (map[pos] == 'H') { // 햄버거
        if (!persons.isEmpty() && Math.abs(pos - persons.poll()) <= K) {
          ans++;
        } else {
          burgers.add(pos);
        }
      } else if (map[pos] == 'P') { // 사람
        if (!burgers.isEmpty() && Math.abs(pos - burgers.poll()) <= K) {
          ans++;
        } else {
          persons.add(pos);
        }
      }
    }
    System.out.println(ans);
  }
}
