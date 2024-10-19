import java.util.*;

class Solution {
    char[] alphabet = new char[]{
        'A', 'E', 'I', 'O', 'U'
    };
    
    ArrayList<String> dict = new ArrayList<>();
    
    public void dfs(int len) {
        if (len >= alphabet.length) return;
        
        String last = "";
        if (dict.size() >= 1) {
            last = dict.get(dict.size() - 1);
        }
        
        for (int i=0; i<alphabet.length; i++) {
            dict.add(last + alphabet[i]);
            dfs(len+1);
        }
    }
    
    public int solution(String word /* 단어 */) {
        dfs(0);
        return dict.indexOf(word) + 1;
    }
}
