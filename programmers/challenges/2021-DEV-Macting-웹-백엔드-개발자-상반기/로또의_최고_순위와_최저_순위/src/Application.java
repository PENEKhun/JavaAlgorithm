public class Application {
public static void main(String[] args) {

        // 3, 5
//        int[] myNumber = {44, 1, 0, 0, 31, 25};
//        int[] winNumber = {31, 10, 45, 1, 6, 19};
        // 1, 6
//        int[] myNumber = {0, 0, 0, 0, 0, 0};
//        int[] winNumber = {31, 10, 45, 1, 6, 19};
        // 1, 1
        int[] myNumber = {45, 4, 35, 20, 3, 9};
        int[] winNumber = {20, 9, 3, 45, 4, 35};


        int[] result = new Solution().solution(myNumber, winNumber);

        for (int i : result) {
            System.out.printf(i + ", ");
        }

    }
}
