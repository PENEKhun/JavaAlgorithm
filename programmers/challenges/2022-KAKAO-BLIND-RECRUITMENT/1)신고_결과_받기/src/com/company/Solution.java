import java.util.*;

class Solution {
    public int[] solution(String[] id_list /* ID 목록 */, String[] reports /*신고*/, int k /*정지 기준*/) {
        Map<String, Set<String>> reportBy = new HashMap<>(); // Key를 신고한 사람 목록
        Map<String, Integer> mailCnt = new HashMap<>();

        for (String username : id_list) {
            reportBy.put(username, new HashSet<>());
        }

        for (String report : reports) {
            String user = report.split(" ")[0];
            String reported = report.split(" ")[1];
            reportBy.get(reported).add(user);
        }

        int[] ans = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            String reported = id_list[i];
            if (reportBy.get(reported).size() >= k) {
                // 신고자들
                for (String reporter : reportBy.get(reported)) {
                    mailCnt.put(reporter, mailCnt.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        for (int i=0; i<id_list.length; i++) {
            String user = id_list[i];
            ans[i] = mailCnt.getOrDefault(user, 0);
        }
        return ans;
    }
}