import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> joinMember = new HashMap<>();
        for (String member : participant) {
            joinMember.put(member, joinMember.getOrDefault(member, 0) + 1);
        }
        
        for (String member : completion) {
            int newCnt = joinMember.getOrDefault(member, 0) - 1;
            if (newCnt <= 0) {
                joinMember.remove(member);
            } else {
                joinMember.put(member, newCnt);
            }
        }
        
        String ans = "";
        for (String member : joinMember.keySet()) {
            ans = member;
        }
        return ans;
    }
}