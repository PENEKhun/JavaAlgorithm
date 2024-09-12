import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
  BAEKJOON 16928 뱀과 사다리 게임
  https://www.acmicpc.net/problem/16928
*/

public class Main {
  static int[] sadari = new int[108];
  static int[] snake = new int[108];
  static boolean[] visited = new boolean[108];

  public static class State {
    int position;
    int duration;

    public State(int position) {
      this.position = position;
    }

    public State(int position, int duration) {
      this.position = position;
      this.duration = duration;
    }

    public void go(int number) {
      this.duration++;
      this.position += number;
      if (snake[this.position] != 0) {
        this.position = snake[this.position];
      } else if (sadari[this.position] != 0) {
        this.position = sadari[this.position];
      }
    }

    public boolean isVisitedBefore() {
      return visited[this.position];
    }

    public State clone() {
      return new State(this.position, this.duration);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = input[0]; // 사다리 수
    int M = input[1]; // 뱀의 수

    for (int i = 0; i < N; i++) {
      input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      sadari[input[0]] = input[1];
    }

    for (int i = 0; i < M; i++) {
      input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      snake[input[0]] = input[1];
    }

    Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.duration));
    pq.add(new State(1));
    while (!pq.isEmpty()) {
      State poll = pq.poll();

      if (poll.position == 100) {
        System.out.println(poll.duration);
        break;
      }
      for (int i = 1; i <= 6; i++) {
        State newState = poll.clone();
        newState.go(i);
        if (newState.position <= 100 && !newState.isVisitedBefore()) {
          visited[newState.position] = true;
          pq.add(newState);
        }
      }
    }
  }
}
