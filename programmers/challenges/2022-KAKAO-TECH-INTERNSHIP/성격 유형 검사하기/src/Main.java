import java.util.HashMap;
import java.util.Map;

class Solution {

  /**
   * @param survey  나뉘는 유형 배열
   * @param choices 선택 유형 배열
   * @return 결과 값
   */
  public String solution(String[] survey, int[] choices) {

    Map<String, Integer> score = new HashMap<>();
    for (int i = 0; i < choices.length; i++) {
      int choice = choices[i];
      String no = survey[i].split("")[0];
      String yes = survey[i].split("")[1];

      if (choice == 1 || choice == 2 || choice == 3) {// 비동의 쪽
        score.put(no, score.getOrDefault(no, 0) + (4 - choice));
      } else if (choice == 4) {// 모르겠음
      } else if (choice == 5 || choice == 6 || choice == 7) {// 동의 쪽
        score.put(yes, score.getOrDefault(yes, 0) + (choice - 4));
      }
    }

    StringBuilder answer = new StringBuilder();
    if (score.getOrDefault("R", 0) >= score.getOrDefault("T", 0)) {
      answer.append("R");
    } else {
      answer.append("T");
    }

    if (score.getOrDefault("C", 0) >= score.getOrDefault("F", 0)) {
      answer.append("C");
    } else {
      answer.append("F");
    }

    if (score.getOrDefault("J", 0) >= score.getOrDefault("M", 0)) {
      answer.append("J");
    } else {
      answer.append("M");
    }

    if (score.getOrDefault("A", 0) >= score.getOrDefault("N", 0)) {
      answer.append("A");
    } else {
      answer.append("N");
    }

    return answer.toString();
  }
}