import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/*
  BAEKJOON 1644 소수의 연속합
  https://www.acmicpc.net/problem/1644
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> primeDict = new ArrayList<>();
    Boolean[] isPrime = new Boolean[n + 1];
    isPrime[1] = false;

    for (int i = 2; i <= n; i++) {
      if (isPrime[i] == null) {
        isPrime[i] = true;
        for (int k = i * 2; k <= n; k += i) {
          isPrime[k] = false;
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) {
        primeDict.add(i);
      }
    }


    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (n == 1) {
      bw.write("0\n");
      bw.flush();
      return;
    }

    int l = 0, r = 0;
    int sum = 2;
    int cnt = 0;
    while (l <= r) {
      if (sum == n) {
        cnt++;
        sum -= primeDict.get(l);
        l++;
        r++;
        if (r >= primeDict.size()) {
          break;
        }
        sum += primeDict.get(r);
      } else if (sum > n) {
        sum -= primeDict.get(l);
        l++;
      } else if (sum < n) {
        r++;
        if (r >= primeDict.size()) {
          break;
        }

        sum += primeDict.get(r);
      }
    }

    bw.write(cnt + "\n");
    bw.flush();
  }
}