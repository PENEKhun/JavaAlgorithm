import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int max = nums.length / 2;
        int uniquePocketmons = set.size();
        return Math.min(max, uniquePocketmons);
    }
}