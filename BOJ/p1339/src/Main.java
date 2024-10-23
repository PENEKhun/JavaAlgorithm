import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.midi.Soundbank;

/*
  BAEKJOON 1339 단어 수학
  https://www.acmicpc.net/problem/1339
*/

public class Main {
  static boolean[] valueUsed;
  static HashMap<Character, Integer> mapping = new HashMap<>(20);
  static String[] words;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashSet<Character> alphabetSet = new HashSet<>(20);
    words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
      for (char c : words[i].toCharArray()) {
        alphabetSet.add(c);
      }
    }

    valueUsed = new boolean[10];
    combi(0, alphabetSet.toArray(Character[]::new));
    System.out.println(max);
  }

  private static void combi(int depth, Character[] alphabetArr) {
    if (depth == alphabetArr.length) {
      calc();
      return;
    }

    for (int i = 9; i > (9 - alphabetArr.length); i--) {
      if (!mapping.containsKey(alphabetArr[depth]) && !valueUsed[i]) {
        mapping.put(alphabetArr[depth], i);
        valueUsed[i] = true;
        combi(depth + 1, alphabetArr);
        mapping.remove(alphabetArr[depth]);
        valueUsed[i] = false;
      }
    }
  }

  private static void calc() {
    int result = 0;
    for (String word : words) {
      StringBuilder numSb = new StringBuilder();
      for (char c : word.toCharArray()) {
        numSb.append(mapping.getOrDefault(c, 0));
      }
      result += Integer.parseInt(numSb.toString());
    }
    max = Math.max(max, result);
  }
}
