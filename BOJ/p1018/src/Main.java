import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1018 체스판 다시 칠하기
    url : https://www.acmicpc.net/problem/1018
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int inputH = Integer.parseInt(mn[0]);
        int inputW = Integer.parseInt(mn[1]);

        char[][] chess = new char[inputH][inputW];
        for (int i = 0; i < inputH; i++) {
            String line = br.readLine();
            char[] arr = line.toCharArray();
            System.arraycopy(arr, 0, chess[i], 0, arr.length);
        }

        ArrayList<char[][]> split = new ArrayList<>();
        for (int offsetH = 0; offsetH <= inputH - 8; offsetH++) {
            for (int offsetW = 0; offsetW <= inputW - 8; offsetW++) {

                // 체스판 자르기
                char[][] newChess = new char[8][8];
                for (int h = 0; h < 8; h++) {
                    for (int w = 0; w < 8; w++) {
                        newChess[h][w] = chess[offsetH + h][offsetW + w];
                    }
                }
                split.add(newChess);
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < split.size(); i++) {
            char[][] chkChess = split.get(i);

            for (int first = 0; first < 2; first++) {
                int count = 0;
                char start = 'W';
                if (first == 0) start = 'B';

                for (int h = 0; h < 8; h++) {
                    char startColor = start;
                    if (h % 2 != 0) {
                        startColor = (start == 'W') ? 'B' : 'W';
                    }

                    for (int w = 0; w < 8; w++) {
                        char now = startColor;

                        if (w % 2 != 0){
                            now = (startColor == 'W') ? 'B' : 'W';
                        }

                        if (chkChess[h][w] != now){
                            count++;
                        }
                    }
                }
                result.add(count);
            }
        }
        System.out.println(Arrays.stream(result.toArray()).sorted().toArray()[0]);
    }
}
