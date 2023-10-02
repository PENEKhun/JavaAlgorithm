import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1978 소수 찾기
    url : https://www.acmicpc.net/problem/1978
*/

public class Main {
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 안쓸거임
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.stream(arr).filter(Main::isPrime).count());
    }
}
