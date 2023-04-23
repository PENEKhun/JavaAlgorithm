import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correctCnt = 0;
        int myZeroNumberCnt = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0){
                myZeroNumberCnt++;
            } else {
                for (int k = 0; k < win_nums.length; k++) {
                    if (lottos[i] == win_nums[k]){
                        correctCnt++;
                        break;
                    }
                }
            }
        }

        int[] answer = {0, 0};

        answer[0] = getRank(correctCnt);

        // 최대 몇등인지
        if (myZeroNumberCnt == 0){
            answer[1] = getRank(correctCnt);
        } else if (correctCnt == 6){
            answer[1] = getRank(6);
        } else {
            answer[1] = getRank(correctCnt + myZeroNumberCnt);
        }

        answer = Arrays.stream(answer).sorted().toArray();
        return answer;
    }

    public int getRank(int correctCnt){
        return switch (correctCnt) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
