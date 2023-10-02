import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #2751 수 정렬하기 2
    url : https://www.acmicpc.net/problem/2751
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.stream(arr).sorted().forEach(
            num -> {
                try {
                    bw.write(num + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        );

        bw.flush();
        bw.close();
    }
}
