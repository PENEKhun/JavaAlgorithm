import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  BAEKJOON 2875 대회 or 인턴
  https://www.acmicpc.net/problem/2875
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int girl = Integer.parseInt(input[0]); // 여학생 수
    int boy = Integer.parseInt(input[1]); // 남학생 수
    int k = Integer.parseInt(input[2]); // 인턴쉽 필수 인원

    int maxTeams = Math.min(girl / 2, boy);
    int remaining = girl + boy - maxTeams * 3;
    while(k > remaining && maxTeams > 0) {
      maxTeams--;
      remaining += 3;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(maxTeams + "\n");
    bw.flush();
  }
}