import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]); // 학생 수
        int k = Integer.parseInt(NK[1]); // 구간 수

        // 학생들의 성적
        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder result = new StringBuilder();
        for (int q=0; q<k; q++) {
            // 구간
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int size = end - start + 1;

            double sum = 0;
            for (int i=start-1; i<=end-1; i++) {
                sum += scores[i];
            }

            double avg = sum / size;
            result.append(String.format("%.2f", avg)).append("\n");
        }

        System.out.print(result);
    }
}

