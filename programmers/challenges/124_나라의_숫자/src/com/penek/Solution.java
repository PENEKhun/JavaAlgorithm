package com.penek;

public class Solution {
    public static String solution(int n) {
        String[] oneTwoFour = {"1", "2", "4"};
        StringBuilder answer = new StringBuilder();

        int tmp = n;
        int mok = n;
        int mod;

        while (mok != 0) {
            if (mok / 3 == 0 || mok == 3){
                answer.append(oneTwoFour[mok -1]);
                break;
            }
            if (mok % 3 == 0) {
                mok = (tmp-1)/3;
                mod = 3;
                tmp = mok;
                answer.append(oneTwoFour[2]);
            } else {
                mok = tmp/3;
                mod = tmp%3;
                tmp = mok;
                answer.append(oneTwoFour[mod-1]);
            }
        }

        return answer.reverse().toString();
    }
}