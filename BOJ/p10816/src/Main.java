
/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10816 숫자 카드 2
    url : https://www.acmicpc.net/problem/10816
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 이거 안씀
        String[] myCardInput = br.readLine().split(" ");
        HashMap<Integer, Integer> myCards = new HashMap<>();
        for (int i = 0; i < myCardInput.length; i++) {
            int num = Integer.parseInt(myCardInput[i]);
            myCards.put(num, myCards.getOrDefault(num, 0) + 1);
        }

        br.readLine(); // 이거 안씀
        int[] yourCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int yourCard : yourCards) {
            bw.write(
                myCards.getOrDefault(yourCard, 0) + " "
            );
        }

        bw.newLine();
        bw.flush();
        bw.close();
    }
}
