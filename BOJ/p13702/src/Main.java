import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 13702 이상한 술집
  https://www.acmicpc.net/problem/13702
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] NK = br.readLine().split(" ");
    int n = Integer.parseInt(NK[0]); // 막걸리 주전자 수
    int k = Integer.parseInt(NK[1]); // 은상이 포함 사람수

    long[] makgulri = new long[n];

    long start = 1;
    long end = (long) (Math.pow(2, 23) - 1);

    for (int i = 0; i < n; i++) {
      makgulri[i] = Long.parseLong(br.readLine());
      if (makgulri[i] != 0) {
        end = Math.max(end, makgulri[i]);
      }
    }

    if (n == 1) {
      System.out.println(makgulri[0] / k);
      return;
    }

    long mid = 0;
    while (start <= end) {
      mid = (end + start) / 2;

      long canMake = 0;
      for (long mak : makgulri) {
        canMake += mak / mid;
      }

      if (canMake >= k) {
        // 최소 올려
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    if (end == 0) {
      System.out.println(0);
    } else {
      System.out.println(end);
    }
  }
}
