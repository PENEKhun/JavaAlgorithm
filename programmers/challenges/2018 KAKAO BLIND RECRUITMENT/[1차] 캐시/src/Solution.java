import java.util.*;

class Solution {
    ArrayList<String> cache = new ArrayList<>();
    int cacheSize;
    
    public int solution(int size, String[] cities) {
        cacheSize = size;
        
        int answer = 0;
        for (String city : cities) {
            answer += search(city);
        }
        
        return answer;
    }
    
    private int search(String toSearchLower) {
        if (cacheSize == 0) return 5;
        
        toSearchLower = toSearchLower.toLowerCase();
        
        // 캐싱 되어있을 때
        for (int i=0; i<cache.size(); i++) {
            if (toSearchLower.equals(cache.get(i))) {
                // 기존꺼 삭제
                cache.remove(i);
                // 앞에 캐싱
                cache.add(0, toSearchLower);
                // 사이즈 조절
                if (cache.size() > cacheSize) {
                    cache.remove(cacheSize);
                }
                // System.out.println("캐시 히트! " + toSearchLower + " , 현재 사이즈 : " + cache.size() + " , " + cache.toString());
                return 1;
            }
        }
        
        
        // 앞에 캐싱
        cache.add(0, toSearchLower);
        // 사이즈 조절
        if (cache.size() > cacheSize) {
            cache.remove(cacheSize);
        }
        // System.out.println("캐시 없음 ㅜㅠ " + toSearchLower + " , 현재 사이즈 : " + cache.size() + " , " + cache.toString());
        return 5;
    }
}