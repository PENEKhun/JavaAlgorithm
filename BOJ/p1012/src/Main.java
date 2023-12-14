import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1012 유기농 배추
    url : https://www.acmicpc.net/problem/1012

    아니 이것도 기본으로 준 케이스가 이해가 안됨
    -> 지용이가 문제 케이스 이해시켜줬음 땡큐 @camp5803
*/

public class Main {

  static boolean[][] baechu;
  static boolean[][] visited;
  static int[] dx = {0, 0, -1, 1, 0};
  static int[] dy = {1, -1, 0, 0, 0};
  static int width;
  static int height;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int t = 0; t < testCase; t++) {
      int result = 0;
      String[] input = br.readLine().split(" ");
      width = Integer.parseInt(input[0]);
      height = Integer.parseInt(input[1]);
      int howManyPosition = Integer.parseInt(input[2]);

      baechu = new boolean[height][width];
      visited = new boolean[height][width];
      for (int i = 0; i < howManyPosition; i++) {
        String[] position = br.readLine().split(" ");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        baechu[y][x] = true;
      }

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          if (!visited[y][x] && baechu[y][x]) {
            visited[y][x] = true;
            bfs(x, y);
            result++;
          }
        }
      }
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static void bfs(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if (newX < 0 || newY < 0) {
        continue;
      }

      if (newX == width || newY == height) {
        continue;
      }

      if (!visited[newY][newX] && baechu[newY][newX]) {
        visited[newY][newX] = true;
        bfs(newX, newY);
      }
    }
  }
}
