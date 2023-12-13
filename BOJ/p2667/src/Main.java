import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2667 단지번호붙이기
    url : https://www.acmicpc.net/problem/2667
*/

public class Main {

  static boolean[][] visited;
  static int[][] square;
  static HashMap<Integer, Integer> result = new HashMap<>();
  static int[] dx = {0, 0, 1, -1, 0}; // 상하좌우 제자리
  static int[] dy = {1, -1, 0, 0, 0}; // 상하좌우 제자리


  static void dfs(int x, int y, int hosu) {
    int size = visited.length - 1;

    for (int i = 0; i < 5; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if (newX < 0 || newY < 0) {
        continue;
      }

      if (newX > size || newY > size) {
        continue;
      }

      if (!visited[newX][newY] && square[newX][newY] == 1) {
        visited[newX][newY] = true;
        result.put(hosu, result.getOrDefault(hosu, 0) + 1);
        dfs(newX, newY, hosu);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    square = new int[len][len];
    for (int i = 0; i < len; i++) {
      square[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }
    visited = new boolean[len][len];

    int hosu = 1;
    for (int i = 0; i < len; i++) {
      int prev = (square[i][0] == 0 ? 1 : 0);
      for (int j = 0; j < len; j++) {
        if (!visited[i][j]) {
          if (square[i][j] == 1 && square[i][j] != prev) {
            dfs(i, j, hosu++);
          }
          prev = square[i][j];
        }
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuilder sb = new StringBuilder();
    sb.append(result.size() + "\n");
    result.values().stream().sorted().forEach(value -> {
      sb.append(value + "\n");
    });
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}
