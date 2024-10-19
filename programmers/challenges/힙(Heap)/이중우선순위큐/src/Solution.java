import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        Queue<Integer> minQ = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        
        
        for (String operate : operations) {
            String[] command = operate.split(" ");
            int operation = Integer.parseInt(command[1]);
            if (command[0].equals("I")) {
                maxQ.add(operation);
                minQ.add(operation);
            } else if (command[0].equals("D")) {
                if (operation == 1) {
                    // 최대 삭제
                    if (!maxQ.isEmpty()) {
                        minQ.remove(maxQ.poll());
                    }
                } else if (operation == -1){
                    // 최소 삭제
                    if (!minQ.isEmpty()) { 
                        maxQ.remove(minQ.poll());
                    }
                }
            }
        }
        
        int[] ans = {0, 0};
        if (!maxQ.isEmpty()) ans[0] = maxQ.peek(); else ans[0] = 0;
        if (!minQ.isEmpty()) ans[1] = minQ.peek(); else ans[1] = 0;
        
        return ans;
    }
}