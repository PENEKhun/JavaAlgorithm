import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2110 공유기 설치
  https://www.acmicpc.net/problem/2110
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = input[0];
    int C = input[1];
    int[] house = new int[N];
    for (int i = 0; i < N; i++) {
      house[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(house);
    int low = 1;
    int high = house[N - 1] - house[0];
    int result = 0;
    while (low <= high) {
      int mid = (low + high) / 2;

      // 설치 가능한지
      int installed = 1; // 첫번째 집
      int lastInstalled = house[0];
      for (int i = 1; i < N; i++) {
        if (house[i] - lastInstalled >= mid) {
          installed++;
          lastInstalled = house[i];
        }
      }

      if (installed >= C) {
        low = mid + 1;
        result = mid;
      } else {
        high = mid - 1;
      }
    }

    System.out.println(result);
  }
}
