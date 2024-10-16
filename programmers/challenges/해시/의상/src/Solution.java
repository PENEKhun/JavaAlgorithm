import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int ans = 1;
        // 각 하나만 쓰는경우
        for (String type : map.keySet()) {
            int quantity = map.get(type);
            int temp = 1; // 안고르는 수            
            // 1개 고르는 수
            temp += quantity;
            ans *= temp;
        }
        
        return ans - 1; // - 모든 옷을 안입은 경우 (여사건?)
    }
}