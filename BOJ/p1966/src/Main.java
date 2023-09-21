import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1966 프린터 큐
    url : https://www.acmicpc.net/problem/1966
*/

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // 케이스 가짓수
        for (int i = 0; i < n; i++) {
            int howManyDocument = s.nextInt();
            int toFind = s.nextInt(); // 순서가 궁금한 문서 인덱스
            Queue<Integer> queue = new LinkedList<>();

            // 문서 중요도 기록
            for (int k = 0; k < howManyDocument; k++) {
                queue.add(s.nextInt());
            }

            // print
            int printOrder = 1;
            while (true){
                int now = queue.poll();
                boolean canPrintNow = queue.stream()
                    .noneMatch((priority) -> (now < priority));

                if (!canPrintNow){
                    // 프린트 미루기
                    queue.add(now);
                    if (toFind <= 0){
                        // 찾을려는 문서 인쇄를 미뤘으면, 인덱스 재기록
                        toFind = queue.size();
                    }
                    toFind--;
                } else if (toFind == 0){
                    // 찾으려는 문서 프린트
                    System.out.println(printOrder++);
                    break;
                } else {
                    // 안찾는 문서 프린트
                    printOrder++;
                    toFind--;
                }
            }
        }
    }
}
