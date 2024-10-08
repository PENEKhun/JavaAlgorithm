import java.util.*;

class Solution {
  public int solution(String skill, String[] skill_trees) {
    char[] skills = skill.toCharArray();
    HashMap<Character, Character> skillMap = new HashMap<>();
    for (int i = 1; i<=skills.length; i++) {
      if (i == skills.length) {
        skillMap.put(skills[i-1], null);
      } else {
        skillMap.put(skills[i-1], skills[i]);
      }
    }

    int result = 0;
    for (String s : skill_trees) {
      char nextSkill = s.charAt(0);
      boolean failed = false;
      for (Character nowSkill : s.toCharArray()) {
        if (skillMap.containsKey(nowSkill)) {
          if (nowSkill != nextSkill) {
            failed = true;
            break;
          }
          nextSkill = skillMap.get(nowSkill);
        }
      }

      if (!failed) {
        result++;
      }
    }

    return result;
  }
}
