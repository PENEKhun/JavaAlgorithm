import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            map.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            map.get(src).add(dest);
            map.get(dest).add(src);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : map.get(current)) {
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1;
                    q.offer(next);
                }
            }
        }
        
        int maxDistance = 0;
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (distances[i] > maxDistance) {
                maxDistance = distances[i];
                count = 1;
            } else if (distances[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}
