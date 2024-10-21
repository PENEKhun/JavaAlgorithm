class Solution {
    public int solution(int n /* 벽의 길이 */, int m /*롤러의 길이 */, int[] section /*다시 페인트를 칠할 구역 번호*/) {
        int ans = 0;
        int currentPos = -1;

        for (int i=0; i<section.length; i++) {
            if (section[i] > currentPos) {
                ans++;
                currentPos = section[i] + m - 1;
            }
        }

        return ans;
    }
}