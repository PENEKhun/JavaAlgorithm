import java.util.Scanner;

public class Main {

  // solved 10-01 계단오르기

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i < n + 1; i++) {
      dp[i] = dp[i-2] + dp[i-1];
    }

    System.out.println(dp[n]);
  }
}