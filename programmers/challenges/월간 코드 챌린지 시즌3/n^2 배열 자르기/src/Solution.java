import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right-left);
        int[] ans = new int[len + 1];
        int i = 0;
        for (long idx=left; idx<=right; idx++) {
            int[] pos = idxToPos(idx, n);
            int val = posToVal(pos);
            ans[i] = val;
            // System.out.println("idx (x,y) -> " + idx + " " + pos[0] + ", " + pos[1]);
            // System.out.println(val);
            i++;
        }
        return ans;
    }
    
    private int[] idxToPos(long idx, int n) {
        int x = (int) (idx % (long) (n)) + 1;
        int y = (int) (idx / (long) n) + 1;
        return new int[]{x, y};
    }
    
    private int posToVal(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        if (x <= y) {
            return y;
        }
        return x;
    }
}