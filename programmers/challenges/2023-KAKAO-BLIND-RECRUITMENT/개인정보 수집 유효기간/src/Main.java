import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  /**
   * @param today     오늘 날짜
   * @param terms     약관의 유효기간을 담은 배열
   * @param privacies 수집된 개인정보의 정보를 담은 배열
   * @return 파기해야할 개인정보의 번호 (오름차순)
   */
  public int[] solution(String today, String[] terms, String[] privacies) {
    LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    Map<String, Integer> term = new HashMap<>();
    for (String item : terms) {
      String[] split = item.split(" ");
      String termType = split[0]; // 약관 종류
      int termExpire = Integer.parseInt(split[1]); // 약관 유효기간 (달 수)

      term.put(termType, termExpire);
    }

    int[] answer = new int[privacies.length];
    for (int i = 0; i < privacies.length; i++) {
      String item = privacies[i];
      String[] split = item.split(" ");
      LocalDate itemDate = LocalDate.parse(split[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
      String itemTermType = split[1];
      int itemTermExpire = term.get(itemTermType);

      if (!itemDate.plusMonths(itemTermExpire).isAfter(todayDate)) {
        answer[i] = i + 1;
      }
    }

    return Arrays.stream(answer).filter(a -> a != 0).toArray();
  }


}