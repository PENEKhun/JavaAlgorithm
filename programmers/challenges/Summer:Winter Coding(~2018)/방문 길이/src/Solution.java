import java.util.*;

class Solution {
    String commands;
    int maxIndex = 0;
    boolean[][][] visited = new boolean[11][11][5];
    
    private int dfs(int i, int x, int y) {
        if (i == maxIndex) {
            return 0;
        }
    
        String command = String.valueOf(commands.charAt(i));
        int newX = x;
        int newY = y;
        // 출발지, 도착지 기준
        int[] flags = new int[2]; // up, down, left, right
        if (command.equals("U")) {
            newY++;
            flags = new int[]{0, 1};
        } else if (command.equals("D")) {
            newY--;
            flags = new int[]{1, 0};
        } else if (command.equals("L")) {
            newX--;
            flags = new int[]{2, 3};
        } else if (command.equals("R")) {
            flags = new int[]{3, 2};
            newX++;
        }
        
        if ((newX < 0 || newX > 10) || (newY < 0 || newY > 10)) {
            return dfs(i+1, x, y);
        } else {
            // 방문 확인
            if (!visited[y][x][flags[0]] && !visited[newY][newX][flags[1]]) {
                visited[y][x][flags[0]] = true;
                visited[newY][newX][flags[1]] = true;
                return dfs(i+1, newX, newY) + 1;
            }
            return dfs(i+1, newX, newY);
        }
    }
    
    public int solution(String dirs) {
        commands = dirs;
        maxIndex = dirs.length();
        return dfs(0, 5, 5);
    }
}