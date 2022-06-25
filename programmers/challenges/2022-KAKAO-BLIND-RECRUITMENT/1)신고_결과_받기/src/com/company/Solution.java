package com.company;

import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {

        HashSet<String> idList = new HashSet<>(List.of(id_list));

        // 각 회원 별 신고 현황
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        // 각 회원별 누적 경고 횟수
        HashMap<String, Integer> reportedMap = new HashMap<>();
        // 정지된 회원
        HashSet<String> overReportedList = new HashSet<>();
        // 신고 리스트(중복 제외)
        HashSet<String> reportWithoutDuplicate = new HashSet<>(List.of(report));

        for (String s : reportWithoutDuplicate) {
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];

            if (!idList.contains(reported) || !idList.contains(reporter))
                continue;

            HashSet<String> reportedList;
            if (reportMap.get(reporter) == null) reportedList = new HashSet<>();
            else reportedList = reportMap.get(reporter);

            Integer reportedCount = reportedMap.get(reported);

            reportedList.add(reported);
            if (reportedCount == null)
                reportedMap.put(reported, 1);
            else {
                if (reportedCount + 1 >= k) {
                    overReportedList.add(reported);
                }
                reportedMap.put(reported, reportedCount + 1);
            }
            reportMap.put(reporter, reportedList);
        }

        int i = 0;
        int[] answer = new int[idList.size()];
        for (Map.Entry<String, HashSet<String>> entry : reportMap.entrySet()) {
            HashSet<String> value = entry.getValue();
            value.retainAll(overReportedList);
            answer[i] = value.size();
            i++;
        }


        return answer;
    }
}