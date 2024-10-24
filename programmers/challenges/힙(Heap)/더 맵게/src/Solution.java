import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for (int val : scoville) {
            minQ.add(val);
        }
        
        int ans = 0;
        while (!minQ.isEmpty()) {
            Integer min = minQ.poll();
            if (min >= k) break;
            
            if (!minQ.isEmpty()) {
                Integer next = minQ.poll();
                int newScovil = min + (next * 2);
                minQ.add(newScovil);
                ans++;
            } else {
                return -1;
            }
        }
        
        return ans;
    }
}