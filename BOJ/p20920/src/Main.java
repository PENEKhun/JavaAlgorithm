import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
  BAEKJOON 20920 영단어 암기는 괴로워
  https://www.acmicpc.net/problem/20920
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] inputs = br.readLine().split(" ");
    int n = Integer.parseInt(inputs[0]); // 단어의 개수
    int m = Integer.parseInt(inputs[1]); // 외울 단어의 길이 (이상)
    HashMap<String, Integer> frequent = new HashMap<>();
    List<String> words = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      if (word.length() >= m) {
        if (!frequent.containsKey(word)) {
          words.add(word);
        }

        frequent.put(
            word,
            frequent.getOrDefault(word, 0) + 1);
      }
    }

    Collections.sort(
        words,
        (a, b) -> {
          int frequentCompare = frequent.get(b) - frequent.get(a);
          if (frequentCompare != 0) {
            return frequentCompare;
          }

          int lengthCompare = b.length() - a.length();
          if (lengthCompare != 0) {
            return lengthCompare;
          }

          return a.compareTo(b);
        }
    );

    StringBuilder result = new StringBuilder();
    for (String word : words) {
      result.append(word).append("\n");
    }

    bw.write(String.valueOf(result));
    bw.flush();
  }
}