import java.util.*;

class Solution {
    HashSet<Integer> numList = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int[] numArr = Arrays.stream(numbers.split(""))
            .sorted()
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int max = 0;
        // System.out.println(Arrays.toString(numArr));
        for (int i=0; i<numArr.length; i++) {
            max += numArr[i] * (Math.pow(10, i));
        }
        
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i=2; i <= Math.sqrt(max); i++) {
            for (int k=i*2; k<=max; k+=i) {
                // System.out.print(String.valueOf(k) + " is not prime");
                isPrime[k] = false;
            }
        }
    
        visited = new boolean[numArr.length];
        numberGen("", numArr);
        int ans = 0;
        Integer[] generatedNum = numList.toArray(Integer[]::new);
        for (Integer num : generatedNum) {
            // System.out.println(num + " is prime ? " + isPrime[num]);
            if (isPrime[num]) ans++;
        }
        
        return ans;
    }
    
    private void numberGen(String num, int[] numArr) {
        if (!num.isEmpty()) numList.add(Integer.parseInt(num));
        
        for (int i=0; i<numArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numberGen(num + numArr[i], numArr);
                numberGen(num, numArr);
                visited[i] = false;
            }
        }
    }
}