import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #9012 괄호
    url : https://www.acmicpc.net/problem/9012
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int howMany = s.nextInt();

        for (int i = 0; i < howMany; i++) {
            String input = s.next();

            while(true){
                int memory = input.length();
                input = input.replace("()", "");
                if (input.length() == memory){
                    if (memory == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }

                    break;
                }
            }
        }
    }
}
