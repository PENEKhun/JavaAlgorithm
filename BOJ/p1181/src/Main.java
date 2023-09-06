import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1181 단어 정렬
    url : https://www.acmicpc.net/problem/1181
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            words.add(s.nextLine());
        }

        words = words.stream().distinct().sorted().toList();
        int lenToPrint = 1;
        while (lenToPrint < 50){
            for (String word : words) {
                if (word.length() == lenToPrint) {
                    System.out.println(word);
                }
            }
            lenToPrint++;
        }
    }
}
