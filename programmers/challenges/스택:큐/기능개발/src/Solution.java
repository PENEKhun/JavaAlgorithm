import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses /* 작업의 진척도 */, int[] speeds /* 개발 속도 */) {
        // 뒤에 있는 기능이 앞에보다 먼저 개발될 수 있는데, 이때 뒷기능은 앞 기능 배포시 같이 배포.
        int size = speeds.length;
        if (size == 0) {
            return new Integer[]{};
        }
        
        int[] remain = new int[size];
        for (int i=0; i<size; i++) {
            int remainPercent = 100 - progresses[i];
            remain[i] = (remainPercent / speeds[i]);
            if (remainPercent % speeds[i] != 0) remain[i] += 1;
        }
        
        // System.out.println(Arrays.toString(remain));
        List<Integer> result = new ArrayList<>(101);
        int max = remain[0];
        int cnt = 0;
        for (int i=0; i<size; i++) {
            if (remain[i] > max) {
                result.add(cnt);
                cnt = 1;
                max = remain[i];
            } else {
                cnt++;
            }
        }
        
        if (cnt != 0) result.add(cnt);
        return result.stream().toArray(Integer[]::new);
    }
}