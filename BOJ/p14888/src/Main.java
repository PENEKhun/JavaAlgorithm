import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
      BAEKJOON 14888 연산자 끼워넣기
      https://www.acmicpc.net/problem/14888
*/

public class Main {

  static int n;
  static int[] num;
  static int[] operator;
  static Integer max = null;
  static Integer min = null;

  public enum Operator {
    ADD(0), SUB(1), TIME(2), DIV(3);

    public final int value;

    Operator(int value) {
      this.value = value;
    }

    public static Operator getOperator(int value) {
      for (Operator operator : Operator.values()) {
        if (operator.value == value) {
          return operator;
        }
      }
      throw new IllegalArgumentException("error");
    }

    public int calc(int a, int b) {
      return switch (this) {
        case ADD -> a + b;
        case SUB -> a - b;
        case TIME -> a * b;
        case DIV -> a / b;
      };
    }

    public static Operator[] append(Operator[] arr, Operator toAdd) {
      Operator[] result = Arrays.copyOf(arr, arr.length + 1);
      result[result.length - 1] = toAdd;
      return result;
    }
  }

  public static void dfs(Operator[] used, int[] remainOperator) {
    remainOperator[used[used.length - 1].value]--;

    if (used.length == n - 1) {
      int tmp = num[0];
      for (int i = 1; i < num.length; i++) {
        tmp = used[i - 1].calc(tmp, num[i]);
      }

      if (min == null || min > tmp) {
        min = tmp;
      }

      if (max == null || max < tmp) {
        max = tmp;
      }
      return;
    }

    for (int i = 0; i < remainOperator.length; i++) {
      if (remainOperator[i] != 0) {
        dfs(Operator.append(used.clone(), Operator.getOperator(i)), remainOperator.clone());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 수의 갯수
    num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    // 덧셈 뺄셈 곱셉 나눗셈 갯수
    operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    // 나눗셈은 몫만, 우선순위 무시, 앞에서부터 계산
    for (int i = 0; i < operator.length; i++) {
      if (operator[i] > 0) {
        Operator[] used = new Operator[] {Operator.getOperator(i)};
        dfs(used, operator.clone());
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(max + "\n" + min + "\n");
    bw.flush();
  }
}
