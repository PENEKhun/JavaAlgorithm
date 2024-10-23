import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int w = Integer.MIN_VALUE;
        int h = Integer.MIN_VALUE;
        
        for (int[] card : sizes) {
            int min = Math.min(card[0], card[1]);
            int max = Math.max(card[0], card[1]);
            w = Math.max(w, min);
            h = Math.max(h, max);
        }
        
        return w * h;
    }
}