import java.util.*;

class Solution {
    private int[] sol(int[][] arr, int startX, int startY, int size) {    
        int val = arr[startY][startX];
        boolean isAllSame = true;
        for (int x=startX; x<startX + size; x++) {
            for (int y=startY; y<startY + size; y++) {
                if (arr[y][x] != val) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) break;
        }
        
        if (isAllSame) {
            // 전부 같음.
            if (val == 0) {
                return new int[]{1, 0};
            }
            
            return new int[]{0, 1};
        }
        // 쪼갬
        int newSize = size/2;
        int[] a = sol(arr, startX, startY, newSize); // 1사
        int[] b = sol(arr, startX + newSize, startY, newSize); // 2사
        int[] c = sol(arr, startX, startY + newSize, newSize); // 3사
        int[] d = sol(arr, startX + newSize, startY + newSize, newSize); // 3사

        return new int[]{a[0] + b[0] + c[0] + d[0], a[1] + b[1] + c[1] + d[1]};
    }
    
    public int[] solution(int[][] arr) {
        int size = arr.length;
        // element가 전부 같을때 까지
        // return {0개수, 1개수}
        int[] answer = sol(arr, 0, 0, size);
        return answer;
    }
}