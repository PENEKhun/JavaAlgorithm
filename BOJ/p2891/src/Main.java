import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2891 카약과 강풍
  https://www.acmicpc.net/problem/2891
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]); // 팀의 수
    int s = Integer.parseInt(input[1]); // 카약이 손상된 팀의 수
    int r = Integer.parseInt(input[2]); // 타약을 하나 더 가져온 팀의 수
    boolean[] brokenTeam = new boolean[n + 1];
    boolean[] moreKayakTeam = new boolean[n + 1];

    input = br.readLine().split(" ");
    for (String team : input) {
      brokenTeam[Integer.parseInt(team)] = true;
    }

    input = br.readLine().split(" ");
    for (String team : input) {
      if (brokenTeam[Integer.parseInt(team)]) {
        brokenTeam[Integer.parseInt(team)] = false;
      } else {
        moreKayakTeam[Integer.parseInt(team)] = true;
      }
    }

    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (brokenTeam[i]) {
        if (i <= n - 1 && moreKayakTeam[i + 1]) {
          brokenTeam[i] = false;
          moreKayakTeam[i + 1] = false;
        } else {
          result++;
        }
      } else if (moreKayakTeam[i]) {
        if (i <= n - 1 && brokenTeam[i + 1]) {
          moreKayakTeam[i] = false;
          brokenTeam[i + 1] = false;
        }
      }
    }

    System.out.println(result);
  }
}