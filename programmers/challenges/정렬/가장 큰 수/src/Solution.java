import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        StringBuilder ans = new StringBuilder();
        String[] strNumbers = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((o1, o2) -> {
                return (o1 + o2).compareTo(o2 + o1);
            })
            .toArray(String[]::new);
        
        // System.out.println(Arrays.toString(strNumbers));
        for (int i=numbers.length - 1; i >= 0; i--){
            ans.append(strNumbers[i]);
        }
        String result = ans.toString();
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }
}