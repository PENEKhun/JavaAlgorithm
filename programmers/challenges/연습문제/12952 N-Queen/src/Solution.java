class Solution {
  boolean[] sero;
  boolean[] updaegak; // 증가하는 대각선
  boolean[] downdaegak; // 감소하는 대각선
  int result = 0;

  public int solution(int n) {
    sero = new boolean[n];
    updaegak = new boolean[2 * n + 2];
    downdaegak = new boolean[2 * n + 2];

    dfs(0, n);
    return result;
  }

  public void dfs(int row, int size) {
    if (row == size) {
      result++;
      return;
    }

    for (int col = 0; col < size; col++) {
      int diff = row - col + size;
      if (!sero[col] && !updaegak[row + col] && !downdaegak[diff]) {
        sero[col] = updaegak[row + col] = downdaegak[diff] = true;
        dfs(row + 1, size);
        sero[col] = updaegak[row + col] = downdaegak[diff] = false;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(4));
  }
}
