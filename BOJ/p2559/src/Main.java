import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  BAEKJOON 2559 수열
  https://www.acmicpc.net/problem/2559
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] NK = br.readLine().split(" ");
    int n = Integer.parseInt(NK[0]);
    int k = Integer.parseInt(NK[1]);
    int[] temper = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] result = new int[n - k + 1];
    for (int i = 0; i < k; i++) {
      result[0] += temper[i];
    }

    int delArr = 0;
    int addArr = k;

    while (addArr < n) {
      int temp = result[delArr];
      temp -= temper[delArr];
      delArr++;
      result[delArr] = temp + temper[addArr];
      addArr++;
    }

    int max = Integer.MIN_VALUE;
    for (int val : result) {
      max = Math.max(max, val);
    }

    System.out.println(max);
  }
}
