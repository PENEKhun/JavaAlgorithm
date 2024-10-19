import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String operation : operations) {
            String[] command = operation.split(" ");
            int num = Integer.parseInt(command[1]);
            
            if (command[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (!map.isEmpty()) {
                int removeKey = num == 1 ? map.lastKey() : map.firstKey();
                if (map.get(removeKey) == 1) {
                    map.remove(removeKey);
                } else {
                    map.put(removeKey, map.get(removeKey) - 1);
                }
            }
        }
        
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}