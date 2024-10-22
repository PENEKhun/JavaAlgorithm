import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        // 위아래 최소 횟수 계산
        for (int i = 0; i < length; i++) {
            int upDown = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            answer += upDown;
        }
        
        // 좌우 최소 횟수 계산
        int minMove = length - 1; // 오른쪽으로만 이동하는 경우
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            // 연속된 'A'의 수를 계산
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            // 좌우 이동의 최소값 갱신
            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next));
        }
        answer += minMove;
        return answer;
    }
}
