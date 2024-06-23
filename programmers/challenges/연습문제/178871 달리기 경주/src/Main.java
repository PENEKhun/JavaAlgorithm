import java.util.Arrays;
import java.util.HashMap;

class Solution {

  public String[] solution(String[] players, String[] callings) {
    HashMap<String, Integer> nameToRank = new HashMap<>();
    HashMap<Integer, String> rankToName = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      rankToName.put(i, players[i]);
      nameToRank.put(players[i], i);
    }

    for (String calling : callings) {
      int rankBehind = nameToRank.get(calling);
      String nameFront = rankToName.get(rankBehind - 1);
      players[rankBehind] = nameFront;
      players[rankBehind - 1] = calling;

      rankToName.put(rankBehind, nameFront);
      rankToName.put(rankBehind - 1, calling);
      nameToRank.put(nameFront, rankBehind);
      nameToRank.put(calling, rankBehind - 1);
    }

    return players;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(solution.solution(new String[] {"mumu", "soe", "poe", "kai", "mine"},
            new String[] {"kai", "kai", "mine", "mine"}))
    );
  }
}