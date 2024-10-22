import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int lastSignalEnd = 0;
        int sum = 0;
        int oneSize = 2 * w + 1;

        for (int installedAt : stations) {
            int signalStart = installedAt - w;
            int signalEnd = installedAt + w;

            if (lastSignalEnd < signalStart) {
                int needSignal = signalStart - lastSignalEnd - 1;
                if (needSignal > 0) {
                    sum += (needSignal + oneSize - 1) / oneSize;
                }
            }

            lastSignalEnd = signalEnd;
        }

        if (lastSignalEnd < n) {
            int needSignal = n - lastSignalEnd;
            sum += (needSignal + oneSize - 1) / oneSize;
        }

        return sum;
    }
}
