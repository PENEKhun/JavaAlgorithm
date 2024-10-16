import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> phoneSet = new HashSet<>(Arrays.asList(phone_book));
        
        for (String phoneNumber : phone_book) {
            StringBuilder prefix = new StringBuilder(21);
            for (int i = 0; i < phoneNumber.length() - 1; i++) {
                prefix.append(phoneNumber.charAt(i));
                if (phoneSet.contains(prefix.toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
