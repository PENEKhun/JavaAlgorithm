import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;
        int before = -1;
        for (int i=0; i<arr.length; i++) {
            int now = arr[i];
            if (now == before) {
                arr[i] = -1;
                size--;
            }
            before = now;
        }
        
        int[] ans = new int[size];
        int idx = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != -1) {
                ans[idx++] = arr[i];
            }
        }
        
        return ans;
    }
}