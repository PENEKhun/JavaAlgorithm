package com.penek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(Solution.solution("one4seveneight"));
    }

    public static class Solution {

        public static void replaceAll(StringBuilder builder, String from, String to)
        {
            int index = builder.indexOf(from);
            while (index != -1)
            {
                builder.replace(index, index + from.length(), to);
                index += to.length();
                index = builder.indexOf(from, index);
            }
        }

        public static int solution(String s) {
            StringBuilder stringNumber = new StringBuilder(s);
            HashMap<String, String> replaceMap = new HashMap<>();


            /*
            0	zero
            1	one
            2	two
            3	three
            4	four
            5	five
            6	six
            7	seven
            8	eight
            9	nine
             */

            replaceMap.put("zero", "0");
            replaceMap.put("one", "1");
            replaceMap.put("two", "2");
            replaceMap.put("three", "3");
            replaceMap.put("four", "4");
            replaceMap.put("five", "5");
            replaceMap.put("six", "6");
            replaceMap.put("seven", "7");
            replaceMap.put("eight", "8");
            replaceMap.put("nine", "9");

            for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
                replaceAll(stringNumber, entry.getKey(), entry.getValue());
            }
            return Integer.parseInt(stringNumber.toString());
        }
    }
}
