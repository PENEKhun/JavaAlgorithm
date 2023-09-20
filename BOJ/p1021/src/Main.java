import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1021 회전하는 큐
    url : https://www.acmicpc.net/problem/1021
*/

public class Main {
    public static int[] rightShift(int[] arr){
        int[] temp = arr.clone();

        for (int i = 0; i < arr.length - 1; i++) {
            temp[i+1] = arr[i];
        }
        temp[0] = arr[arr.length - 1];

        return temp;
    }

    public static int[] leftShift(int[] arr){
        int[] temp = arr.clone();

        for (int i = arr.length - 1; i >= 1; i--) {
            temp[i-1] = arr[i];
        }
        temp[arr.length - 1] = arr[0];

        return temp;
    }

    private static int[] peek(int[] arr) {
        int[] temp = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            temp[i-1] = arr[i];
        }

        return temp;
    }

    public static boolean isClosedZeroIndex(int[] arr, int value){
        for (int pos = 0; pos < arr.length; pos++) {
            if (value == arr[pos]){
                int distanceRight = arr.length - pos;
              return pos < distanceRight;
            }
        }
        throw new IllegalArgumentException("Error");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int peekSize = s.nextInt();

        int[] toPeek = new int[peekSize]; // 뽑을 숫자
        for (int i = 0; i < peekSize; i++) {
            toPeek[i] = s.nextInt();
        }

        // 배열로 큐 대충 묘사
        int[] queue = new int[size];
        for (int i = 0; i < size; i++) {
            queue[i] = i+1;
        }

        int cnt = 0;
        for (int i = 0; i < toPeek.length; i++) {
            while (true) {
                if (queue[0] == toPeek[i]) {
                    queue = peek(queue);
                    break;
                }

                if (isClosedZeroIndex(queue, toPeek[i])){
                    queue = leftShift(queue);
                } else {
                    queue = rightShift(queue);
                }

                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
