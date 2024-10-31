import java.util.*;

class Solution {
    int[][] dungeons;
    int k;
    int max = 0;
    
    public int solution(int initK, int[][] temp) {
        int answer = -1;
        dungeons = temp;
        k = initK;
        int n = temp.length;
        getCombinations(n, 0, 0, new Integer[n + 1], new boolean[n]);
        return max;
    }
    
    private void getCombinations(int n, int depth, int now, Integer[] route, boolean[] visited) {
        if (depth == n) {
            // 계산
            calc(route, k);
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            
            // 안감
            visited[i] = true;
            getCombinations(n, depth + 1, now, route, visited);
            route[now] = null;
            visited[i] = false;
            
            // 감
            visited[i] = true;
            route[now] = i;
            getCombinations(n, depth + 1, now + 1, route, visited);
            route[now+1] = null;
            visited[i] = false;
        }
    }
    
    private void calc(Integer[] routes, int tired) {
        // System.out.println(Arrays.toString(routes));
        int visited = 0;
        for (Integer route : routes) {
            if (route == null) continue;
            int required = dungeons[route][0];
            int minus = dungeons[route][1];
            
            if (required > tired) {
                return;
            }
            
            visited++;
            tired -= minus;
        }
        
        max = Math.max(max, visited);
        return;
    }
}