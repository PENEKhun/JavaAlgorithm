import java.util.*;

class Solution {
    public int solution(int n /* 전체 학생수 */, int[] lost /* 도난당한 학생의 번호 */, int[] reserve /* 여벌을 챙겨온 학생의 번호 */) {
        // 여벌의 체육복은 앞, 뒤 학생에게만 빌려줄 수 있음.
        HashSet<Integer> lostStudents = new HashSet<>();
        HashSet<Integer> reserveStudents = new HashSet<>();
        
        for (int reserveNum : reserve) {
            reserveStudents.add(reserveNum);
        }
        
        for (int lostNum : lost) {
            if (reserveStudents.contains(lostNum)) {
                reserveStudents.remove(lostNum);
            } else {
                lostStudents.add(lostNum);
            }
        }
        
        int ans = 0;
        for (int i=1; i<=n; i++) {
            int frontNum = i-1;
            int backNum = i+1;
            
            if (!lostStudents.contains(i)) {
                ans++;
            } else if (reserveStudents.contains(frontNum)) {
                reserveStudents.remove(frontNum);
                ans++;
            } else if (reserveStudents.contains(backNum)) {
                reserveStudents.remove(backNum);
                ans++;
            }
        }
        return ans; // 체육복을 입을 수 있는 학생들의 최대
    }
}