import java.util.*;

class Solution {
    int[] myWeapons;
    int result = Integer.MAX_VALUE;
    
    public void dfs(int idx, String[] minerals, int tired, int nowWeapon, int nowWeaponeLife) {
        // 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
        if (idx == minerals.length || (myWeapons[0] == 0 && myWeapons[1] == 0 && myWeapons[2] == 0 && nowWeaponeLife <= 0)) {
            result = Math.min(result, tired);
            return;
        }
        
        if (nowWeapon == -1 || nowWeaponeLife <= 0) {
            // System.out.println("무기 변경 ");
            // 무기 변경
            for (int i=0; i<myWeapons.length; i++) {
                if (myWeapons[i] >= 1) { // 사용가능한 괭이면
                    myWeapons[i]--;
                    dfs(idx, minerals, tired, i, 5);
                    myWeapons[i]++;
                }
            }
            return;
        }
        
        
        // 광물 캐기
        String mineral = minerals[idx];
        int toAddedTired = 0;
        if (nowWeapon == 0) { // diamond
            toAddedTired = 1;
        } else if (nowWeapon == 1) { // iron
            if (mineral.equals("diamond")) {
                toAddedTired = 5;
            } else {
                toAddedTired = 1;
            }
        } else if (nowWeapon == 2) { // stone
            if (mineral.equals("diamond")) {
                toAddedTired = 25;
            } else if (mineral.equals("iron")) {
                toAddedTired = 5;
            } else {
                toAddedTired = 1;
            }
        }
        
        dfs(idx+1, minerals, tired + toAddedTired, nowWeapon, nowWeaponeLife-1);
    }
    
    public int solution(int[] picks, String[] minerals) {
        // picks 곡갱이 개수 {다이아, 철, 돌} - 최소 한개씩 이상
        // minerals 광물의 순서. {diamond, iron, stone ....}
        // 곡괭이 하나당 수명이 5
        
        myWeapons = picks;
        dfs(0, minerals, 0, -1, -1);
        return result;
    }
}