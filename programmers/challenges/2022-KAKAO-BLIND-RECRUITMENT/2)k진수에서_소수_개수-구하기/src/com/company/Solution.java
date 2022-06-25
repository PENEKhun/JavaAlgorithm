package com.company;
public class Solution {

    public static int solution(int n, int k) {
        int answer = 0;
        //n 진수로 변환
        StringBuilder q = conversion(n, k);
        String[] sp = q.toString().split("0");
        for (String s : sp) {
            if (!(s.isBlank() && s.isEmpty())){
                if (isPrime(Long.parseLong(s))) answer++;
            }
        }
        return answer;
    }

    public static StringBuilder conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
        int current = number;
        while(current > 0){
            if(current % N < 10){
                sb.append(current % N);
            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
        return sb.reverse();
    }

    public static boolean isPrime(long n){
        if(n==0 || n==1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(long i=3; i<=(long)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

}