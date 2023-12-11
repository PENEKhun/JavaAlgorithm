import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #7569 토마토
    url : https://www.acmicpc.net/problem/7569
*/

public class Main {

  static class Cord {

    int height;
    int width;
    int len;

    public Cord(int height, int len, int width) {
      this.height = height;
      this.width = width;
      this.len = len;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int maxWidth = Integer.parseInt(input[0]); // 가로칸 수
    int maxLen = Integer.parseInt(input[1]); // 세로 칸 수
    int maxHeight = Integer.parseInt(input[2]); // 쌓아지는 상자 수

    int[][][] tomatoes = new int[maxHeight][maxLen][maxWidth];

    for (int f = 0; f < maxHeight; f++) {
      // 층별로
      for (int len = 0; len < maxLen; len++) {
        // 상태 저장
        int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tomatoes[f][len] = row;
      }
    }

    int dayLeft = 0;
    boolean status = checkTomatoAllDone(tomatoes);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (status) {
      // 전부 익었으면 종료
      bw.write("0\n");
    } else {

      ArrayList<Cord> changed = new ArrayList<>();
      for (int floor = 0; floor < tomatoes.length; floor++) {
        int[][] nowFloor = tomatoes[floor];
        for (int len = 0; len < nowFloor.length; len++) {
          int[] row = nowFloor[len];
          for (int wid = 0; wid < row.length; wid++) {
            int now = tomatoes[floor][len][wid];
            if (now == 1) {
              changed.add(new Cord(floor, len, wid));
            }
          }
        }
      }
      
      // 토마토 익게하기
      while (true) {

        if (checkTomatoAllDone(tomatoes)) {
          break;
        }

        ArrayList<Cord> newChanged = new ArrayList<>();
        for (Cord cord : changed) {
          int floor = cord.height;
          int len = cord.len;
          int wid = cord.width;

          int now = tomatoes[floor][len][wid];
          if (now == 1) {
            if (floor != 0) {
              if (canMakeTomato(tomatoes, floor - 1, len, wid)) {
                tomatoes[floor - 1][len][wid] = 1;
                newChanged.add(new Cord(floor - 1, len, wid));
              }
            }

            if (floor != tomatoes.length - 1) {
              if (canMakeTomato(tomatoes, floor + 1, len, wid)) {
                tomatoes[floor + 1][len][wid] = 1;
                newChanged.add(new Cord(floor + 1, len, wid));
              }
            }

            if (wid != maxWidth - 1) {
              if (canMakeTomato(tomatoes, floor, len, wid + 1)) {
                tomatoes[floor][len][wid + 1] = 1;
                newChanged.add(new Cord(floor, len, wid + 1));
              }
            }

            if (wid != 0) {
              if (canMakeTomato(tomatoes, floor, len, wid - 1)) {
                tomatoes[floor][len][wid - 1] = 1;
                newChanged.add(new Cord(floor, len, wid - 1));
              }
            }

            if (len != maxLen - 1) {
              if (canMakeTomato(tomatoes, floor, len + 1, wid)) {
                tomatoes[floor][len + 1][wid] = 1;
                newChanged.add(new Cord(floor, len + 1, wid));
              }
            }

            if (len != 0) {
              if (canMakeTomato(tomatoes, floor, len - 1, wid)) {
                tomatoes[floor][len - 1][wid] = 1;
                newChanged.add(new Cord(floor, len - 1, wid));
              }
            }
          }
        }

        if (newChanged.isEmpty()) {
          // 변경 사항이 없으면...
          dayLeft = -1;
          break;
        }

        changed = newChanged;
        dayLeft++;
      }
      bw.write(dayLeft + "\n");
    }

    bw.flush();

    bw.close();
    br.close();
  }

  private static boolean canMakeTomato(int[][][] tomatoes, int floor, int len, int wid) {
    return (tomatoes[floor][len][wid] != -1) && (tomatoes[floor][len][wid] != 1);
  }

  private static boolean checkTomatoAllDone(int[][][] tomatoes) {
    return Arrays.stream(tomatoes)
        .flatMap(Arrays::stream)
        .flatMapToInt(Arrays::stream)
        .allMatch(ele -> (ele == 1) || (ele == -1));
  }
}
