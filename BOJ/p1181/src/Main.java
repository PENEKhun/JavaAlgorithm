import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1181 단어 정렬
    url : https://www.acmicpc.net/problem/1181
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        words = Arrays.stream(words).distinct().sorted().toArray(String[]::new);

        int lenToPrint = 1;
        while (lenToPrint <= 50){
            for (String word : words) {
                if (word.length() == lenToPrint) {
                    bw.write(word + "\n");
                }
            }
            lenToPrint++;
        }

        bw.flush();
        bw.close();
    }
}
