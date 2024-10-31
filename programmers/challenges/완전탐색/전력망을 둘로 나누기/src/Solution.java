import java.util.*;

class Solution {
    
    private int dfs(int n, boolean[][] map, boolean[] visited, int start) {
        visited[start] = true;
        int result = 0;
        for (int i=1; i<=n; i++) {
            if (i==start) continue;
            if (!map[start][i]) continue;
            if (visited[i]) continue;
            
            visited[i] = true;
            result += dfs(n, map, visited, i) + 1;
        }
        
        return result;
    }
    
    private int calc(int n, boolean[][] map, int[] toRemove) {
        int src = toRemove[0];
        int dest = toRemove[1];
        map[src][dest] = false;
        map[dest][src] = false;
        
        // 계산
        int a = -1;
        int b = -1;
        boolean[] visited = new boolean[n + 1];
        for (int i=1; i<=n; i++) {
            if (visited[i]) continue;
            int val = dfs(n, map, visited, i);
            
            if (a == -1) a = val; else if (b == -1) b = val;
        }
        
        map[src][dest] = true;
        map[dest][src] = true;
        return Math.abs(a - b);
    }
    
    public int solution(int n /* 송전탑의 개수 */, int[][] wires /* 전선 정보 */) {
        boolean[][] map = new boolean[n+1][n+1];
        int minDiff = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            int src = wire[0];
            int dest = wire[1];
            map[src][dest] = true;
            map[dest][src] = true;
        }
        
        for (int[] wire : wires) {
            minDiff = Math.min(minDiff, calc(n, map, wire));
        }
        
        return minDiff;
    }
}