import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] ans = new int[]{0, 0};
        while (s.length() != 1) {
            // 0제거
            if (s.contains("0")) {
                String temp = s.replaceAll("0", "");
                ans[1] += s.length() - temp.length();
                s = temp;
            }
            
            int num = s.length();
            // num to binary
            s = Integer.toBinaryString(num);
            ans[0]++;
        }
        
        return ans;
    }
}