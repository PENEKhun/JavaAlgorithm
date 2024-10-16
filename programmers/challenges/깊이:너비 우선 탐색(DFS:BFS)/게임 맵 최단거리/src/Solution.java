import java.util.*;

class Solution {
    public class Status {
        int x;
        int y;
        int distance;
        
        public Status(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int solution(int[][] maps) {
        int height = maps.length;
        int width = maps[0].length;
        boolean[][] visited = new boolean[height][width];
        int[][] dxy = new int[][] {
            // 상, 하, 좌, 우
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };
        
        int answer = 0;
        Queue<Status> q = new ArrayDeque<>();
        q.add(new Status(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Status poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            int distance = poll.distance;
            
            if (x == width - 1 && y == height - 1) {
                return distance;
            }
            
            for (int[] xy : dxy) {
                int newX = x + xy[0];
                int newY = y + xy[1];
                
                if (newX < 0 || newX >= width || newY < 0 || newY >= height || visited[newY][newX]) {
                    continue;
                }
                
                if (maps[newY][newX] == 0) {
                    continue;
                }
                
                visited[newY][newX] = true;
                q.add(new Status(newX, newY, distance + 1));
            }
        }
        
        return -1;
    }
}