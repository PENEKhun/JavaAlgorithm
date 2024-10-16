import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1] - 1;
            int toGet = command[2] - 1;
            
            int[] newArr = Arrays.copyOfRange(array, start, end + 1);
            Arrays.sort(newArr);
            answer[idx++] = newArr[toGet];
        }
        
        return answer;
    }
}