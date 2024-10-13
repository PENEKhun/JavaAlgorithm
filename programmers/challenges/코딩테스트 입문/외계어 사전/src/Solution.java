import java.util.*;

class Solution {
    public int solution(String[] spell /* 알파벳 */, String[] dic /*외계어 사전*/) {
        int answer = 0;
        HashSet<String> db = new HashSet<>();
        for (String str : spell) {
            db.add(str);
        }
        
        for (int i = 0; i < dic.length; i++) {
            String word = dic[i];
            if (word.length() != spell.length) {
                continue;
            }
            
            HashSet<String> used = new HashSet<>();
            boolean failed = false;
            
            char[] alphabets = word.toCharArray();
            for (int k = 0; k < alphabets.length; k++){
                String strAlphabet = String.valueOf(alphabets[k]);
                if (used.contains(strAlphabet) || !db.contains(strAlphabet)) {        
                    failed = true;
                    break;
                }
                used.add(strAlphabet);
            }
            
            if (failed) {
                continue;
            } else {
                return 1;
            }
        }
        
        return 2;
    }
}