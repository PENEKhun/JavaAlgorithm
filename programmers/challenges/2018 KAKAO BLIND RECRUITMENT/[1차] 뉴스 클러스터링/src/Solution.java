import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        char[] s1c = str1.toCharArray();
        char[] s2c = str2.toCharArray();
        HashMap<String, Integer> oneSet = new HashMap<>();
        HashMap<String, Integer> twoSet = new HashMap<>();
    
        // str1
        for (int i = 0; i < s1c.length - 1; i++) {
            if (!(isAlpabet(s1c[i]) && isAlpabet(s1c[i+1]))) {
                continue;
            }
                
            if (s1c[i] >= 'a') {
                s1c[i] -= 'a' - 'A';
            }
            
            if (s1c[i+1] >= 'a') {
                s1c[i+1] -= 'a' - 'A';
            }

            String item = String.valueOf(s1c[i]) + String.valueOf(s1c[i+1]);
            oneSet.put(item, oneSet.getOrDefault(item, 0) + 1);
        }
        
        // str2
        for (int i = 0; i < s2c.length - 1; i++) {
            if (!(isAlpabet(s2c[i]) && isAlpabet(s2c[i+1]))) {
                continue;
            }
                
            if (s2c[i] >= 'a') {
                s2c[i] -= 'a' - 'A';
            }
            
            if (s2c[i+1] >= 'a') {
                s2c[i+1] -= 'a' - 'A';
            }
            
            String item = String.valueOf(s2c[i]) + String.valueOf(s2c[i+1]);
            twoSet.put(item, twoSet.getOrDefault(item, 0) + 1);
        }

        
        // a, b가 모두 공집합이면 = 1
        if (oneSet.isEmpty() && twoSet.isEmpty()) {
            return 65536;
        }
        
        int hap = 0;
        int gyo = 0;
        HashSet<String> calculated = new HashSet<>();
        for (String item : oneSet.keySet()) {
            if (calculated.contains(item)) continue;
            
            if (twoSet.containsKey(item)) {
                gyo += Math.min(oneSet.get(item), twoSet.get(item));
                hap += Math.max(oneSet.get(item), twoSet.get(item));
            } else {
                hap += oneSet.get(item);
            }
            
            calculated.add(item);
        }
        
        for (String item : twoSet.keySet()) {
            if (calculated.contains(item)) continue;
            if (oneSet.containsKey(item)) {
                gyo += Math.min(oneSet.get(item), twoSet.get(item));
                hap += Math.max(oneSet.get(item), twoSet.get(item));
            } else {
                hap += twoSet.get(item);
            }
            calculated.add(item);
        }

        float ans = (gyo * 65536 / hap);
        return (int) ans;
    }
    
    public boolean isAlpabet(char a) {
        return (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z');
    }
}