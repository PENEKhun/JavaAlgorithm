import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
  BAEKJOON 23971 ZOAC 4
  https://www.acmicpc.net/problem/23971
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int h = inputs[0]; // 높이
    int w = inputs[1]; // 가로 길이
    int n = inputs[2]; // 세로 비워
    int m = inputs[3]; // 가로 비워

    double sero = (double) h / (n + 1);
    int s = h / (n + 1);
    if (sero % 1 > 0) {
      s += 1;
    }
    double garo = (double) w / (m + 1);
    int g = w / (m + 1);
    if (garo % 1 > 0) {
      g += 1;
    }
    bw.write((s * g) + "\n");
    bw.flush();
  }
}