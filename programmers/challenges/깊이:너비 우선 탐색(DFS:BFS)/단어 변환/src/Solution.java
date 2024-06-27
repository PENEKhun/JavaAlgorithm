import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

  static class KV {

    public String word;
    public int depth;

    public KV(String word, int depth) {
      this.word = word;
      this.depth = depth;
    }
  }

  public boolean canTransform(String text, String target) {
    char[] c1 = text.toCharArray();
    char[] c2 = target.toCharArray();
    int len = text.length();

    short diff = 0;
    for (int i = 0; i < len; i++) {
      if (c1[i] != c2[i]) {
        diff++;
      }

      if (diff > 1) {
        break;
      }
    }

    return diff == 1;
  }

  public int solution(String begin, String target, String[] words) {
    if (Arrays.stream(words).filter(w -> w.equals(target)).findAny().isEmpty()) {
      return 0;
    }

    Queue<KV> q = new LinkedList<>();
    q.add(new KV(begin, 0));

    int result = 0;
    while (!q.isEmpty()) {
      KV item = q.poll();
      if (Objects.equals(item.word, target)) {
        result = item.depth;
        break;
      }

      for (String word : words) {
        if (canTransform(item.word, word)) {
          q.add(new KV(word, item.depth + 1));
        }
      }
    }
    return result;
  }
}