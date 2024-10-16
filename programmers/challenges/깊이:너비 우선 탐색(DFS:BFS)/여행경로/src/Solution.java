import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> result = new ArrayList<>();
    
    public void dfs(int used, String src, String route, String[][] tickets) {
        if (used == tickets.length) {
            result.add(route);
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            String[] nowTicket = tickets[i];
            if (nowTicket[0].equals(src) && !visited[i]) {
                visited[i] = true;
                dfs(used+1, nowTicket[1], route + " " + nowTicket[1], tickets);
                visited[i] = false;
            }
        }
        
        return;
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        
        dfs(0, "ICN", "ICN", tickets);
        return result.get(0).split(" ");
    }
}