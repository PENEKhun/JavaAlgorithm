import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2606 바이러스
    url : https://www.acmicpc.net/problem/2606
*/

public class Main {

  static boolean[][] networkGraph;
  static boolean[] visited;

  static int count = -1;

  public static void solution(short source) {
    for (short dest = 1; dest < networkGraph[source].length; dest++) {
      if (networkGraph[source][dest] && !visited[dest]) {
        count++;
        visited[dest] = true;
        solution(dest);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int howManyComputers = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    networkGraph = new boolean[howManyComputers + 1][howManyComputers + 1];
    visited = new boolean[howManyComputers + 1];

    for (int i = 0; i < M; i++) {
      String[] inputs = br.readLine().split(" ");
      short source = Short.parseShort(inputs[0]);
      short dest = Short.parseShort(inputs[1]);
      networkGraph[source][dest] = true;
      networkGraph[dest][source] = true;
    }

    solution((short) 1);

    if (count == -1) {
      count = 0;
    }
    bw.write(count + "\n");
    bw.flush();
  }
}
