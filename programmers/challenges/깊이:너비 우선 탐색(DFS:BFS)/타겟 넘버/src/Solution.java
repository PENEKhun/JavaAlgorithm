class Solution {
    int answer = 0;
    int[] arr;
    
    public int dfs(int i, int sum, int target) {
        if (i == arr.length - 1) {
            if (sum == target) {
                return 1;
            }
            
            return 0;
        }
        
        // 더하고
        int next = i + 1;
        int plus = dfs(next, sum + arr[next], target);
        // 빼기
        int minus = dfs(next, sum - arr[next], target);
        
        return plus + minus;
    }
    
    public int solution(int[] numbers, int target) {
        arr = numbers;
        return dfs(-1, 0, target);
    }
}