import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 1717 집합의 표현
  https://www.acmicpc.net/problem/1717
*/

public class Main {
  static int[] arr;

  static void combine(int a, int b) {
    a = getParent(a);
    b = getParent(b);
    // 무조건 작은쪽으로 합쳐야함.
    if (a > b) arr[a] = b;
    else arr[b] = a;
  }

  static int getParent(int target) {
    if (arr[target] == target) {
      return target;
    }
    return arr[target] = getParent(arr[target]);
  }

  static boolean checkCombine(int a, int b) {
    return getParent(a) == getParent(b);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int n = Integer.parseInt(NM[0]);
    int m = Integer.parseInt(NM[1]);

    arr = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      arr[i] = i;
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String[] inputs = br.readLine().split(" ");
      int flag = Integer.parseInt(inputs[0]);
      int a = Integer.parseInt(inputs[1]);
      int b = Integer.parseInt(inputs[2]);
      if (flag == 0) {
        combine(a, b);
      } else {
        // 포함확인 1
        if (checkCombine(a, b)) {
          result.append("YES").append("\n");
        } else {
          result.append("NO").append("\n");
        }
      }
    }

    System.out.print(result);
  }
}
