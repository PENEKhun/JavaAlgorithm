import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1929 소수 구하기
    url : https://www.acmicpc.net/problem/1929
*/

public class Main {
    public static boolean isPrime(int n){
        if (n == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = input[0];
        int b = input[1];
        int sqrt = (int) Math.ceil(Math.sqrt(b));
        Boolean[] notPrime = new Boolean[b+1];
        notPrime[1] = true;

        for (int i = 2; i <= sqrt; i++) {
            if (isPrime(i)) {
                for (int mul = i*2; mul <= b; mul += i) {
                    notPrime[mul] = true;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = a; i < notPrime.length; i++) {
            if (notPrime[i] == null) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
