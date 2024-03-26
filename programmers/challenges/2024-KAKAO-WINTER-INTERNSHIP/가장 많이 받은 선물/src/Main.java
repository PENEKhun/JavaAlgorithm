import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    /*System.out.println(
        solution.solution(new String[] {"muzi", "ryan", "frodo", "neo"},
            new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
                "frodo ryan", "neo muzi"})
    );*/

    System.out.println(
        solution.solution(new String[] {"joy", "brad", "alessandro", "conan", "david"},
            new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro",
                "alessandro david"})
    );


  }

  public int solution(String[] friends, String[] gifts) {
    HashMap<String, Integer> nameToIndex = new HashMap<>();
    for (int i = 0; i < friends.length; i++) {
      nameToIndex.put(friends[i], i);
    }

    int[][] database = new int[friends.length][friends.length];
    int[] giftScore = new int[friends.length];
    for (String data : gifts) {
      String[] parse = data.split(" ");
      String src = parse[0];
      String dest = parse[1];

      database[nameToIndex.get(src)][nameToIndex.get(dest)]++;
      giftScore[nameToIndex.get(src)]++;
      giftScore[nameToIndex.get(dest)]--;
    }

    System.out.println(Arrays.toString(giftScore));
    int[] futureDB = new int[friends.length];
    int ans = 0;
    HashMap<String, Boolean> visited = new HashMap<>();

    for (int i = 0; i < friends.length; i++) {
      for (int k = 0; k < friends.length; k++) {
        String src = friends[i];
        String dest = friends[k];

        int srcToDest = database[nameToIndex.get(src)][nameToIndex.get(dest)];
        int destToSrc = database[nameToIndex.get(dest)][nameToIndex.get(src)];

        if (i == k || visited.getOrDefault(src + " " + dest, false)) {
          continue;
        }

        visited.put(src + " " + dest, true);
        visited.put(dest + " " + src, true);

        // 선물 지수 계산
        int srcGiftScore = giftScore[nameToIndex.get(src)];
        int destGiftScore = giftScore[nameToIndex.get(dest)];

        if (srcToDest != 0 || destToSrc != 0) {
          // 많이 준 사람이 선물 받음
          if (srcToDest > destToSrc) {
            ans = Math.max(ans, ++futureDB[nameToIndex.get(src)]);
          } else if (srcToDest < destToSrc) {
            ans = Math.max(ans, ++futureDB[nameToIndex.get(dest)]);
          } else {
            if (srcGiftScore > destGiftScore) {
              ans = Math.max(ans, ++futureDB[nameToIndex.get(src)]);
            } else if (srcGiftScore < destGiftScore) {
              ans = Math.max(ans, ++futureDB[nameToIndex.get(dest)]);
            }
          }

          continue;
        }

        if (srcGiftScore > destGiftScore) {
          ans = Math.max(ans, ++futureDB[nameToIndex.get(src)]);
        } else if (srcGiftScore < destGiftScore) {
          ans = Math.max(ans, ++futureDB[nameToIndex.get(dest)]);
        }
      }
    }

    System.out.println(Arrays.toString(futureDB));

    return ans;
  }
}