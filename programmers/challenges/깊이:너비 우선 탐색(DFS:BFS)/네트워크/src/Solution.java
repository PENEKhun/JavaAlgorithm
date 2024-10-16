class Solution {
    int[][] networks;
    boolean[] visited;
    
    public void dfs(int idx) {
        visited[idx] = true;
        
        int[] connected = networks[idx];
        for (int i=0; i<networks.length; i++) {
            if (connected[i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        networks = computers;
        visited = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i);
            } 
        }
        
        return ans;
    }
}