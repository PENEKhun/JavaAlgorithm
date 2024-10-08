import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int w = 1; w < 10_000; w++) {
            for (int h = 1; h < 10_000; h++) {
                if (w * h > 2_500_000) continue;
                boolean state1 = 2 * w + 2 * h - 4 == brown;
                boolean state2 = (w - 2) * (h - 2) == yellow;
                if (state1 && state2) {
                    return new int[]{h, w};
                }
            }
        }
        return new int[]{0, 0};
    }
}